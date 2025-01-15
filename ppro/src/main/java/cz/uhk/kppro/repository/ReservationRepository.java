package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
