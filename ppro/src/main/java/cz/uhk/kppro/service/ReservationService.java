package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    List<Reservation> getReservations();
    List<Reservation> getReservationsByUserId(Long userId);
    Reservation getReservation(Long id);
    Reservation deleteReservation(Long id);
    boolean addReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation);

}
