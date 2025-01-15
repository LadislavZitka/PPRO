package cz.uhk.kppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cz.uhk.kppro.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
