package com.soporte.tickets;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.soporte.tickets.models.Ticket;
import com.soporte.tickets.models.entity.TicketEntity;
import com.soporte.tickets.repository.TicketRepository;
import com.soporte.tickets.service.TicketService;



public class TicketsTest {

    @Mock
    private TicketRepository ticketRepository;
    
    @InjectMocks
    private TicketService ticketService;

    private Ticket ticket;
    private TicketEntity ticketEntity;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        ticket = new Ticket(1,"Problemita","Las funciones de crear ticket no me aparecen correctamente");
        ticketEntity = new TicketEntity();
        ticketEntity.setId(1);
        ticketEntity.setTitulo("Problemita");
        ticketEntity.setDescripcion("Las funciones de crear ticket no me aparecen correctamente");
    }

    @Test
    public void testHacerTicket_creado(){
        when(ticketRepository.existsById(ticket.getId())).thenReturn(false);
        when(ticketRepository.save(any(TicketEntity.class))).thenReturn(ticketEntity);

        String resultado = ticketService.hacerTicket(ticket);
        assertEquals("Ticket creado con exito, muchas gracias", resultado);
    }

    @Test
    public void testHacerTicket_ocupado(){
        when(ticketRepository.existsById(ticket.getId())).thenReturn(true);
        

        String resultado = ticketService.hacerTicket(ticket);
        assertEquals("Id ocupada", resultado);
    }

    @Test
    public void testMostrarTicket_encontrado(){
        when(ticketRepository.findById(1)).thenReturn(ticketEntity);
        Ticket resultado = ticketService.traerTicket(1);
        assertNotNull(resultado);
        assertEquals("Problemita", resultado.getTitulo());
    }

    @Test
    public void testMostrarTicket_noEncontrado(){
        when(ticketRepository.findById(2)).thenReturn(null);
        Ticket resultado = ticketService.traerTicket(2);
        assertNotNull(resultado);
    }    

    @Test
    public void testBorrarTicket_exito(){
        when(ticketRepository.existsById(1)).thenReturn(true);
        doNothing().when(ticketRepository).deleteById(1);
        String resultado = ticketService.borrarTicket(1);

        assertEquals("Ticket Borrado con exito", resultado);
    }

    @Test
    public void testBorrarTicket_noEncontrado(){
        when(ticketRepository.existsById(233)).thenReturn(false);
        String resultado = ticketService.borrarTicket(233);

        assertEquals("Ticket no encontrado", resultado);
    }

    /* 
    @Test
    public void testActualizarTicket_existe(){
        when(ticketRepository.findById(1)).thenReturn(Optional.of(ticketEntity));
        when(ticketRepository.save(any(TicketEntity.class))).thenReturn(ticketEntity);

        Ticket tick = new Ticket(1,"Problemita","Las funciones de crear ticket no me aparecen correctamente");
        String resultado = ticketService.actualizarTicket(1, tick);
        assertEquals("Ticket actualizado con exito", resultado);
    }

    @Test
    public void testActualizarTicket_noExiste(){
        when(ticketRepository.findById(3)).thenReturn(Optional.empty());
        

        Ticket tick = new Ticket(3,"Problemon","El problema escapa de mi comprension");
        String resultado = ticketService.actualizarTicket(3, tick);
        assertEquals("Ticket no encontrado", resultado);
    }
    */
}
