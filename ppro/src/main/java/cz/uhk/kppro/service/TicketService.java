package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Reservation;
import cz.uhk.kppro.model.Seat;
import cz.uhk.kppro.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    Ticket createTicket(Reservation reservation, Seat seat, double price);
    List<Ticket> getTicketByReservation(Reservation reservation);
    List<Ticket> getTicketBySeat(Seat seat);
    Ticket getTicket(Long id);
}
