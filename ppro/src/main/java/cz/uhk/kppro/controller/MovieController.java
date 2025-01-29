package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Movie;
import cz.uhk.kppro.service.MovieService;
import cz.uhk.kppro.service.ScreeningService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    private MovieService movieService;
    private ScreeningService screeningService;

    @Autowired
    public MovieController(MovieService movieService, ScreeningService screeningService) {
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @GetMapping("/admin/moviesAdmin")
    public String moviesAdmin(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/movies_admin";
    }
    @GetMapping("/admin/movieDetailAdmin/{id}")
    public String movieDetailAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("screenings", screeningService.getAllScreeningsByMovieId(id));
        return "admin/movie_admin_detail";
    }
    @GetMapping("/movieDetail/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("screenings", screeningService.getAllScreeningsByMovieId(id));
        return "movie_detail";
    }
    @GetMapping("/admin/movieEditAdmin/{id}")
    public String movieEdit(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("edit", true);
        return "admin/movie_admin_edit";
    }
    @GetMapping("/admin/movieCreateAdmin")
    public String movieCreate(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("edit", false);
        return "admin/movie_admin_edit";
    }
    @GetMapping("/admin/movieDeleteAdmin/{id}")
    public String movieDelete(@PathVariable Long id, Model model) {
        movieService.deleteMovie(id);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/movieSaveAdmin")
    public String movieSave(@Valid Movie movie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", false);
            return "admin/movie_admin_edit";
        }
        movieService.addMovie(movie);
        return "redirect:/admin/admin";
    }
    @PostMapping("/admin/movieUpdateAdmin")
    public String movieUpdate(@Valid Movie movie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);
            return "admin/movie_admin_edit";
        }
        movieService.updateMovie(movie);
        return "redirect:/admin/admin";
    }
}
