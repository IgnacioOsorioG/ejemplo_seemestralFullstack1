package com.soporte.tickets.models.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketEntity {

    @GetMapping("/test")
    public String holaMundo(){
        return "probando spring";
    }

    @GetMapping("/tickets")
    public List<Ticket> mostrarTicket(){
        
    }

}
