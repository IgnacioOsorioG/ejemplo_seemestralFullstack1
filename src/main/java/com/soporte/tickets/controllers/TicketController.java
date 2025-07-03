package com.soporte.tickets.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soporte.tickets.models.Ticket;
import com.soporte.tickets.repository.TicketRepository;
import com.soporte.tickets.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class TicketController {

    private final TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketservice;
    TicketService accionTicket = new TicketService();

    TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Operation(summary="Probando conexion")
    @GetMapping("/test")
    public String holaMundo() {
        return "probando spring";
    }

    @Operation(summary="muestra todos los tickets")
    @GetMapping("/tickets")
    public List<Ticket> mostrarTickets() {
        return ticketservice.obtenerTickets();
    }

    @Operation(summary="Mostrar un ticket especifico usando la id")
    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> traerTicket(@PathVariable int id) {
        return ResponseEntity.ok(ticketservice.traerTicket(id));
    }

    @Operation(summary="Borrar un ticket especifico usando su id")
    @DeleteMapping("/tickets/{id}")
    public String borrarTicket(@PathVariable int id) {
        return ticketservice.borrarTicket(id);
    }
    
    @Operation(summary="Crear un ticket")
    @PostMapping("/tickets")
    public ResponseEntity<String> crearTicket(@RequestBody Ticket ticket){
        return ResponseEntity.status(201).body(ticketservice.hacerTicket(ticket));
    }
    
    @Operation(summary="Actualizar ticket")
    @PutMapping("tickets/{id}")
    public ResponseEntity<String> actualizarTicket(@PathVariable int id, @RequestBody Ticket ticket){
        return ResponseEntity.status(201).body(ticketservice.actualizarTicket(id, ticket));
    }
        
        
    
}  
    

