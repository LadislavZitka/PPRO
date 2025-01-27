package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Movie deleteMovie(Long id);
    boolean addMovie(Movie movie);
    boolean updateMovie(Movie movie);
}
