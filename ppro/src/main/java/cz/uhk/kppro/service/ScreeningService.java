package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Screening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScreeningService {
    List<Screening> getAllScreenings();
    List<Screening> getAllScreeningsByHallId(Long hallId);
    List<Screening> getAllScreeningsByMovieId(Long movieId);
    Screening getScreeningById(Long id);
    Screening deleteScreening(Long id);
    boolean addScreening(Screening screening);
    boolean updateScreening(Screening screening);
}
