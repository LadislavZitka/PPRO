package cz.uhk.kppro.controller;

import cz.uhk.kppro.service.*;
import cz.uhk.kppro.util.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
    private UserService userService;
    private ScreeningService screeningService;
    private ReservationService reservationService;
    //private CarService carService;
    //private DriverService driverService;
    //private WeatherService weatherService;

    @Autowired
    public HelloController(UserService userService, ScreeningService screeningService, ReservationService reservationService) {
        this.userService = userService;
        this.screeningService = screeningService;
        this.reservationService = reservationService;
    }

    @GetMapping(value = {"/","/home"})
    public String home(Model model){
        model.addAttribute("screenings", screeningService.getAllScreenings());
        model.addAttribute("reservations", reservationService.getReservationsByUserId(userService.getCurrentUser().getId()));
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }

    @GetMapping("/admin/admin")
    public String admin(){
        return "admin/admin";
    }

}