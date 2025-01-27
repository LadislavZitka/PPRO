package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findAllByHallId(long hallId);
    List<Screening> findAllByMovieId(long movieId);
}
