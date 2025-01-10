package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Reservation;
import cz.uhk.kppro.model.Seat;
import cz.uhk.kppro.model.Ticket;
import cz.uhk.kppro.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Reservation reservation, Seat seat, double price) {
        Ticket ticket = new Ticket();
        ticket.setReservation(reservation);
        ticket.setSeat(seat);
        ticket.setPrice(price);
        ticket.setBookingTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTicketByReservation(Reservation reservation) {
        return ticketRepository.findByReservation(reservation);
    }

    @Override
    public List<Ticket> getTicketBySeat(Seat seat) {
        return ticketRepository.findBySeat(seat);
    }

    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
