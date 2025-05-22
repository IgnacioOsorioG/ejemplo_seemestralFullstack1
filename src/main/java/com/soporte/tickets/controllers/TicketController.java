package com.soporte.tickets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.soporte.tickets.models.Ticket;
import com.soporte.tickets.repository.TicketRepository;
import com.soporte.tickets.service.TicketService;

@RestController
public class TicketController {

    private final TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketservice;
    TicketService accionTicket = new TicketService();

    TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/test")
    public String holaMundo() {
        return "probando spring";
    }

    @GetMapping("/tickets")
    public List<Ticket> mostrarTickets() {
        return accionTicket.obtenerTickets();
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> traerTicket(@PathVariable int id) {
        return ResponseEntity.ok(ticketservice.traerTicket(id));
    }

    @DeleteMapping("/tickets/{id}")
    public String borrarTicket(@PathVariable int id) {
        return accionTicket.borrarTicket(id);
    }
}
