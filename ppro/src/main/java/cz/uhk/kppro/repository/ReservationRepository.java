package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserId(Long userId);
    Boolean existsByUserIdAndScreeningId(Long userId, Long screeningId);

}
