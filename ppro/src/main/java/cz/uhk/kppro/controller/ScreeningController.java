package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Screening;
import cz.uhk.kppro.service.HallService;
import cz.uhk.kppro.service.MovieService;
import cz.uhk.kppro.service.ScreeningService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScreeningController {
    private ScreeningService screeningService;
    private MovieService movieService;
    private HallService hallService;

    @Autowired
    public ScreeningController(ScreeningService screeningService, MovieService movieService, HallService hallService) {
        this.screeningService = screeningService;
        this.movieService = movieService;
        this.hallService = hallService;
    }

    @GetMapping("/admin/screeningsAdmin")
    public String screeningsAdmin(Model model) {
        model.addAttribute("screenings", screeningService.getAllScreenings());
        return "admin/screenings_admin";
    }

    @GetMapping("/admin/screeningDetailAdmin/{id}")
    public String screeningDetail(@PathVariable Long id, Model model) {
        model.addAttribute("screening", screeningService.getScreeningById(id));
        return "admin/screening_admin_detail";
    }
    @GetMapping("/admin/screeningEditAdmin/{id}")
    public String screeningEdit(@PathVariable Long id, Model model) {
        model.addAttribute("screening", screeningService.getScreeningById(id));
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("halls", hallService.getAllHalls());
        model.addAttribute("edit", true);
        return "admin/screening_admin_edit";
    }
    @GetMapping("/admin/screeningCreateAdmin")
    public String screeningCreate(Model model) {
        model.addAttribute("screening", new Screening());
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("halls", hallService.getAllHalls());
        model.addAttribute("edit", false);
        return "admin/screening_admin_edit";
    }
    @GetMapping("/admin/screeningDeleteAdmin/{id}")
    public String screeningDelete(@PathVariable Long id, Model model) {
        screeningService.deleteScreening(id);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/screeningSaveAdmin")
    public String screeningSave(@Valid Screening screening, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "admin/screening_admin_edit";
        }
        screeningService.addScreening(screening);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/screeningUpdateAdmin")
    public String screeningUpdate(@Valid Screening screening, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "admin/screening_admin_edit";
        }
        screeningService.updateScreening(screening);
        return "redirect:/admin/admin";
    }
}
