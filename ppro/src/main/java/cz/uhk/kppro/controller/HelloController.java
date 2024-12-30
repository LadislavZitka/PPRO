package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    private List<Car> cars = new ArrayList<Car>();

    @GetMapping("/")
    public String listCars(Model model) {
        model.addAttribute("cars", cars);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String carDetails(@PathVariable int id, Model model) {
        model.addAttribute("car", cars.get(id));
        model.addAttribute("id", id);
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        model.addAttribute("car", cars.get(id));
        model.addAttribute("edit", true);
        return "edit";
    }

    @GetMapping("/create")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("edit", false);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        cars.remove(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car) {
        int index = getCarIndex(car.getSpz());
        if (index != -1) {
            cars.remove(index);
        }
        cars.add(car);
        return "redirect:/";
    }

    private int getCarIndex(String spz) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getSpz().equals(spz)) {
                return i;
            }
        }
        return -1;
    }
}
