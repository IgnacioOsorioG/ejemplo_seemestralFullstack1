package com.soporte.tickets.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository extends JpaRepository<TicketEntity,Integer> {

}
