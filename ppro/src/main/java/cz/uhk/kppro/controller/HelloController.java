package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Car;
import cz.uhk.kppro.service.CarService;
import cz.uhk.kppro.service.DriverService;
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
    private DriverService driverService;

    @Autowired
    public HelloController(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "list";
    }

    //private List<Car> cars = new ArrayList<Car>();


}
