package com.soporte.tickets.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soporte.tickets.models.entity.TicketEntity;

@Repository
public class TicketRepository extends JpaRepository<TicketEntity,Integer> {
    TicketEntity findById(int id);
    boolean existsById(int id);
    void deleteById(int id);
}
