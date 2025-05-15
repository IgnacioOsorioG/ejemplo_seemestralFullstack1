package com.soporte.tickets.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporte.tickets.models.Ticket;
import com.soporte.tickets.models.entity.TicketEntity;
import com.soporte.tickets.repository.TicketRepository;

@Service
public class TicketService {

@Autowired
private TicketRepository ticketRepository;
private final List<Ticket> tickets = new ArrayList<>();


public TicketService(){
    tickets.add(new Ticket(1,"",""));
}

public List<Ticket> obtenerTickets(){
    return tickets;
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
public String borrarTicket(int id){
    for (Ticket tick : tickets){
        if (tick.getId()==id){
            tickets.remove(tick);
            return "ticket removido con exito";
        }
    }
    return null;
}


}
