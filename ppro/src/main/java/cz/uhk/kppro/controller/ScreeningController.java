package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Screening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScreeningController {
    @GetMapping("/screeningDetail/{id}")
    public String screeningDetail(@PathVariable Long id, Model model) {
        return "screening_detail";
    }
    @GetMapping("/screeningEdit/{id}")
    public String screeningEdit(@PathVariable Long id, Model model) {
        return "screening_edit";
    }
    @GetMapping("/screeningCreate")
    public String screeningCreate() {
        return "screening_edit";
    }
    @GetMapping("/screeningDelete/{id}")
    public String screeningDelete(@PathVariable Long id, Model model) {
        return "redirect:/home";
    }
    @PostMapping("/screeningSave")
    public String screeningSave(@ModelAttribute Screening screening) {
        return "redirect:/home";
    }
    @PostMapping("/screeningUpdate")
    public String screeningUpdate(@ModelAttribute Screening screening, Model model) {
        return "redirect:/home";
    }
}
