package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Hall;
import cz.uhk.kppro.service.HallService;
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
public class    HallController {
    private HallService hallService;
    private ScreeningService screeningService;

    @Autowired
    public HallController(HallService hallService, ScreeningService screeningService) {
        this.hallService = hallService;
        this.screeningService = screeningService;
    }

    @GetMapping("/admin/hallsAdmin")
    public String hallsAdmin(Model model) {
        model.addAttribute("halls", hallService.getAllHalls());
        return "admin/halls_admin";
    }

    @GetMapping("/admin/hallDetailAdmin/{id}")
    public String hallDetail(@PathVariable Long id, Model model) {
        model.addAttribute("hall", hallService.getHallById(id));
        model.addAttribute("screenings", screeningService.getAllScreeningsByHallId(id));
        return "admin/hall_admin_detail";
    }
    @GetMapping("/admin/hallEditAdmin/{id}")
    public String hallEdit(@PathVariable Long id, Model model) {
        model.addAttribute("hall", hallService.getHallById(id));
        model.addAttribute("edit", true);
        return "admin/hall_admin_edit";
    }

    @GetMapping("/admin/hallCreateAdmin")
    public String hallCreate(Model model) {
        model.addAttribute("hall", new Hall());
        model.addAttribute("edit", false);
        return "admin/hall_admin_edit";
    }
    @GetMapping("/admin/hallDeleteAdmin/{id}")
    public String hallDelete(@PathVariable Long id, Model model) {
        hallService.deleteHall(id);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/hallSaveAdmin")
    public String hallSave(@Valid Hall hall, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "admin/hall_admin_edit";
        }
        hallService.addHall(hall);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/hallUpdateAdmin")
    public String hallUpdate(@Valid Hall hall, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "admin/hall_admin_edit";
        }
        hallService.updateHall(hall);
        return "redirect:/admin/admin";
    }
}
