package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    @GetMapping("/movieDetail/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        return "movie_detail";
    }
    @GetMapping("/movieEdit/{id}")
    public String movieEdit(@PathVariable Long id, Model model) {
        return "movie_edit";
    }
    @GetMapping("/movieCreate")
    public String movieCreate() {
        return "movie_edit";
    }
    @GetMapping("/movieDelete/{id}")
    public String movieDelete(@PathVariable Long id, Model model) {
        return "redirect:/home";
    }
    @PostMapping("/movieSave")
    public String movieSave(@ModelAttribute Movie movie) {
        return "redirect:/home";
    }
    @PostMapping("/movieUpdate")
    public String movieUpdate(@ModelAttribute Movie movie, Model model) {
        return "redirect:/home";
    }
}
