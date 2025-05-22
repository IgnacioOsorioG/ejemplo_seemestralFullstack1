package com.soporte.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soporte.tickets.models.entity.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    TicketEntity findById(int id);

    boolean existsById(int id);

    void deleteById(int id);
}
