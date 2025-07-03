package com.soporte.tickets.models.entity;

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

}
