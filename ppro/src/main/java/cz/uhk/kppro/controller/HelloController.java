package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Car;
import cz.uhk.kppro.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CarService carService;
    //private List<Car> cars = new ArrayList<Car>();

    @Autowired
    public HelloController(CarService carService) { this.carService = carService; }

    @GetMapping("/")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String carDetails(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("id", id);
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("edit", true);
        return "edit";
    }

    @GetMapping("/create")
    public String editCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("edit", false);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String createCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCar(@ModelAttribute Car car) {
        carService.updateCar(car);
        return "redirect:/";
    }
/*
    private int getCarIndex(String spz) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getSpz().equals(spz)) {
                return i;
            }
        }
        return -1;
    }
 */
}
