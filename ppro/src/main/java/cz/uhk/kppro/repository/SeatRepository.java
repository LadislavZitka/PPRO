package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
