package com.example.vokzalproj.repository;

import com.example.vokzalproj.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
