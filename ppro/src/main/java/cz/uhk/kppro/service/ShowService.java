package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {
    Show getShow(Long id);
    List<Show> getAllShows();
    void save(Show show);
    void delete(Long id);
}
