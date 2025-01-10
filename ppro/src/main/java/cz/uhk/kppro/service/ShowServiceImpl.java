package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Show;
import cz.uhk.kppro.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show getShow(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public void save(Show show) {
        showRepository.save(show);
    }

    @Override
    public void delete(Long id) {
        showRepository.deleteById(id);
    }
}
