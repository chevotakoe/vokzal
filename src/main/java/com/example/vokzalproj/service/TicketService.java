package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Ticket;

import java.util.ArrayList;

public interface TicketService {
    Ticket getTicketById(int id);
    ArrayList<Ticket> getAllTickets();
    void addTicket(Ticket ticket);
    void updateTicketById(Ticket ticket, int id);
    boolean removeTicketById(int id);
}
