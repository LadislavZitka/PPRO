package cz.uhk.kppro.controller;


import cz.uhk.kppro.model.Reservation;
import cz.uhk.kppro.service.ReservationService;
import cz.uhk.kppro.service.ScreeningService;
import cz.uhk.kppro.service.UserService;
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
public class ReservationController {
    private ReservationService reservationService;
    private UserService userService;
    private ScreeningService screeningService;

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService, ScreeningService screeningService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.screeningService = screeningService;
    }

    @GetMapping("/admin/reservationsAdmin")
    public String reservationsAdmin(Model model) {
        model.addAttribute("reservations", reservationService.getReservations());
        return "admin/reservations_admin";
    }

    @GetMapping("/reservationDetail/{id}")
    public String reservationDetail(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservation(id));
        return "reservation_detail";
    }

    @GetMapping("/admin/reservationDetailAdmin/{id}")
    public String reservationDetailAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservation(id));
        return "admin/reservation_admin_detail";
    }

    @GetMapping("/reservationEdit/{id}")
    public String reservationEdit(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservation(id));
        model.addAttribute("edit", true);
        return "admin/reservation_admin_edit";
    }
    @GetMapping("/reservationCreate")
    public String reservationCreate(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("edit", false);
        return "admin/reservation_admin_edit";
    }
    @GetMapping("/reservationDelete/{id}")
    public String reservationDelete(@PathVariable Long id, Model model) {
        reservationService.deleteReservation(id);
        return "redirect:/home";
    }
    @GetMapping("/admin/reservationDeleteAdmin/{id}")
    public String reservationDeleteAdmin(@PathVariable Long id, Model model) {
        reservationService.deleteReservation(id);
        return "redirect:/admin/admin";
    }
    @PostMapping("/reservationSave/{id}")
    public String reservationSave(@PathVariable Long id, Model model) {
        if(!reservationService.existsReservationByUserIdAndScreeningId(userService.getCurrentUser().getId(), id)){
            reservationService.addReservation(new Reservation(screeningService.getScreeningById(id), userService.getCurrentUser()));
        }
        return "redirect:/home";
    }
    @PostMapping("/admin/reservationSaveAdmin")
    public String reservationSaveAdmin(@Valid Reservation reservation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "admin/reservation_admin_edit";
        }
        reservationService.addReservation(reservation);
        return "redirect:/admin/admin";
    }

    @PostMapping("/admin/reservationUpdateAdmin")
    public String reservationUpdateAdmin(@Valid Reservation reservation,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "admin/reservation_admin_edit";
        }
        reservationService.updateReservation(reservation);
        return "redirect:/admin/admin";
    }

}
