package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Reservation;
import cz.uhk.kppro.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }


    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findAllByUserId(userId);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation deleteReservation(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            reservationRepository.delete(reservationOptional.get());
            return reservation;
        }
        return null;
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservation.getId());
        if (reservationOptional.isPresent()) {
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
}
