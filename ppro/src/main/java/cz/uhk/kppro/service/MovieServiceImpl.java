package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Movie;
import cz.uhk.kppro.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie deleteMovie(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movieRepository.delete(movie);
            return movie;
        }
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        movieRepository.save(movie);
        return true;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findById(movie.getId());
        if (movieOptional.isPresent()) {
            movieRepository.save(movie);
            return true;
        }
        return false;
    }
}
