package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Hall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallService {
    List<Hall> getAllHalls();
    Hall getHallById(Long id);
    Hall deleteHall(Long id);
    boolean addHall(Hall hall);
    boolean updateHall(Hall hall);
}
