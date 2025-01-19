package cz.uhk.kppro.controller;


import cz.uhk.kppro.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {


    @GetMapping("/reservationDetail/{id}")
    public String reservationDetail(@PathVariable Long id, Model model) {
        return "reservation_detail";
    }
    @GetMapping("/reservationEdit/{id}")
    public String reservationEdit(@PathVariable Long id, Model model) {
        return "reservation_edit";
    }
    @GetMapping("/reservationCreate")
    public String reservationCreate() {
        return "reservation_edit";
    }
    @GetMapping("/reservationDelete/{id}")
    public String reservationDelete(@PathVariable Long id, Model model) {
        return "redirect:/home";
    }
    @PostMapping("/reservationSave")
    public String reservationSave(@ModelAttribute Reservation reservation) {
        return "redirect:/home";
    }
    @PostMapping("/reservationUpdate")
    public String reservationUpdate(@ModelAttribute Reservation reservation, Model model) {
        return "redirect:/home";
    }

}
