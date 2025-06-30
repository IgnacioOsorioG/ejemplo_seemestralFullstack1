package com.soporte.tickets.service;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 10b6ce9 (se agrego el put y pruebas)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.soporte.tickets.models.Ticket;
import com.soporte.tickets.models.entity.TicketEntity;
import com.soporte.tickets.repository.TicketRepository;

<<<<<<< HEAD
=======


>>>>>>> 10b6ce9 (se agrego el put y pruebas)
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketService() {
        tickets.add(new Ticket(1, "Problemas de login", "No puedo conectarme a la pagina con mi usuario y clave"));
    }

    public List<Ticket> obtenerTickets() {
        return tickets;
    }

    public Ticket traerTicket(int id) {
        try {
            TicketEntity ticket = ticketRepository.findById(id);
            if (ticket != null) {
                Ticket ticketNuevo = new Ticket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion());
                return ticketNuevo;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String borrarTicket(int id) {
        try {
<<<<<<< HEAD
            for (Ticket tick : tickets) {
                if (tick.getId() == id) {
                    ticketRepository.delete(ticketRepository.findById(id));
                    tickets.remove(tick);
                    return "ticket removido con exito";
                }
            }
            return null;
=======
            if (ticketRepository.existsById(id)){
                ticketRepository.deleteById(id);
                return "Ticket Borrado con exito";
            }
            return "Ticket no encontrado";
>>>>>>> 10b6ce9 (se agrego el put y pruebas)
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String hacerTicket(Ticket tick) {
        try {
            boolean estado = ticketRepository.existsById(tick.getId());
            if (!estado) {
                TicketEntity nuevoTicket = new TicketEntity();
                nuevoTicket.setId(tick.getId());
                nuevoTicket.setTitulo(tick.getTitulo());
                nuevoTicket.setDescripcion(tick.getDescripcion());
                ticketRepository.save(nuevoTicket);
                
                tickets.add(new Ticket(nuevoTicket.getId(),tick.getTitulo(),tick.getDescripcion()));
                return "Ticket creado con exito, muchas gracias";
            }
            return "Id ocupada";

        } catch (ObjectOptimisticLockingFailureException e) {
            return "Error de concurrencia: " + e.getMessage();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
<<<<<<< HEAD
=======
    
    public String actualizarTicket(int id, Ticket tick){
        try {
            Optional<TicketEntity> ticketOptional = ticketRepository.findById(id); 
            if (ticketOptional.isPresent()){
                TicketEntity ticket = ticketOptional.get();
                ticket.setId(tick.getId());
                ticket.setTitulo(tick.getTitulo());
                ticket.setDescripcion(tick.getDescripcion());
                return  "Ticket actualizado con exito";
            }
                return "Ticket no encontrado";
        } catch ( Exception e) {
            return "Error al actualizar el ticket: " + e.getMessage();
        }
    }
>>>>>>> 10b6ce9 (se agrego el put y pruebas)
}
