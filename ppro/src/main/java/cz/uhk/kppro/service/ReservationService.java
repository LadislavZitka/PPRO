package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    void Save(Reservation reservation);
    Reservation getReservation(Long id);
    public void delete(Long id);
}
