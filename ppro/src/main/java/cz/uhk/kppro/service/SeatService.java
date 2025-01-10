package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Seat;
import org.springframework.stereotype.Service;

@Service
public interface SeatService {
    Seat getSeat(Long id);
    void save(Seat seat);
    void delete(Long id);
}
