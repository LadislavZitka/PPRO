package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Reservation;
import cz.uhk.kppro.model.Seat;
import cz.uhk.kppro.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByReservation(Reservation reservation);
    List<Ticket> findBySeat(Seat seat);
}
