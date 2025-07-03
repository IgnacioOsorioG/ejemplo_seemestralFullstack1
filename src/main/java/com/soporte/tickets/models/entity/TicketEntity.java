package com.soporte.tickets.models.entity;

<<<<<<< HEAD
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
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "titulo")
    private String titulo;
    private String descripcion;
>>>>>>> master

}
