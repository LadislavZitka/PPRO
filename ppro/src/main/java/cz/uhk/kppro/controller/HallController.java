package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Hall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HallController {
    @GetMapping("/hallDetail/{id}")
    public String hallDetail(@PathVariable Long id, Model model) {
        return "hall_detail";
    }
    @GetMapping("/hallEdit/{id}")
    public String hallEdit(@PathVariable Long id, Model model) {
        return "hall_edit";
    }
    @GetMapping("/hallCreate")
    public String hallCreate() {
        return "hall_edit";
    }
    @GetMapping("/hallDelete/{id}")
    public String hallDelete(@PathVariable Long id, Model model) {
        return "redirect:/home";
    }
    @PostMapping("/hallSave")
    public String hallSave(@ModelAttribute Hall hall) {
        return "redirect:/home";
    }
    @PostMapping("/hallUpdate")
    public String hallUpdate(@ModelAttribute Hall hall, Model model) {
        return "redirect:/home";
    }
}
