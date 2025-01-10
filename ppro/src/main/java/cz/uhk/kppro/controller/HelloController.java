package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Car;
import cz.uhk.kppro.service.CarService;
import cz.uhk.kppro.service.DriverService;
import cz.uhk.kppro.util.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private CarService carService;
    private DriverService driverService;
    private WeatherService weatherService;

    @Autowired
    public HelloController(CarService carService, DriverService driverService, WeatherService weatherService){
        this.carService = carService;
        this.driverService = driverService;
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String main(@RequestParam(required = false) String city, Model model){
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("drivers", driverService.getAllDrivers());
        if(city != null && !city.isEmpty()) {
            String temp = weatherService.getTemp(city);
            model.addAttribute("temp", temp);
        }
        return "list";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}