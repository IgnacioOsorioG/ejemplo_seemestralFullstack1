package com.soporte.tickets.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporte.tickets.models.Ticket;

@Service
public class TicketService {

@Autowired

private final List<Ticket> tickets = new ArrayList<>();


public TicketService(){
    tickets.add(new Ticket());
}

public Ticket traerTicket(int id){
    try{
        TicketEntity ticket = ticketRepository.findById(id);
        if(ticket!=null){
            Ticket ticketNuevo = new Ticket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion());
            return ticketNuevo;
        }
        return null;
    }
    catch(Exception e){
        return null;
    }
}


}
