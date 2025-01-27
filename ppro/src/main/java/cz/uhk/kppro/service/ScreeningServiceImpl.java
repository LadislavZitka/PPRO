package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Screening;
import cz.uhk.kppro.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    ScreeningRepository screeningRepository;
    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<Screening> getAllScreeningsByHallId(Long hallId) {
        return screeningRepository.findAllByHallId(hallId);
    }

    @Override
    public List<Screening> getAllScreeningsByMovieId(Long movieId) {
        return screeningRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Long id) {
        return screeningRepository.findById(id).orElse(null);
    }

    @Override
    public Screening deleteScreening(Long id) {
        Optional<Screening> screeningOptional = screeningRepository.findById(id);
        if (screeningOptional.isPresent()) {
            Screening screening = screeningOptional.get();
            screeningRepository.delete(screeningOptional.get());
            return screening;
        }
        return null;
    }

    @Override
    public boolean addScreening(Screening screening) {
        screeningRepository.save(screening);
        return true;
    }

    @Override
    public boolean updateScreening(Screening screening) {
        Optional<Screening> screeningOptional = screeningRepository.findById(screening.getId());
        if (screeningOptional.isPresent()) {
            screeningRepository.save(screening);
            return true;
        }
        return false;
    }
}
