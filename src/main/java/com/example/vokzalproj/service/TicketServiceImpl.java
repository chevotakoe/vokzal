package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.model.Ticket;
import com.example.vokzalproj.repository.AdminRepository;
import com.example.vokzalproj.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket getTicketById(int id) {
        Ticket ticket = new Ticket();
        if(ticketRepository.existsById(id)){
            ticket = ticketRepository.findById(id).orElse(null);
        }
        return ticket;
    }

    @Override
    public ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketRepository.findAll();
        return tickets;
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void updateTicketById(Ticket ticket, int id) {
        ticket.setId(id);
        ticketRepository.save(ticket);
    }

    @Override
    public boolean removeTicketById(int id) {
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
