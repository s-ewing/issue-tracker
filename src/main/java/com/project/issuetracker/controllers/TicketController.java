package com.project.issuetracker.controllers;

import com.project.issuetracker.models.Ticket;
import com.project.issuetracker.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/projects/{projectId}/tickets")
    public Ticket createTicket(@RequestBody Ticket newTicket, @PathVariable Integer projectId) {
        return ticketService.createTicket(newTicket, projectId);
    }

    @PutMapping("/projects/{projectId}/tickets/{ticketId}")
    public Ticket assignTicketToUser(@PathVariable Integer ticketId, @RequestParam Integer userId) {
        return ticketService.assignTicketToUser(ticketId, userId);
    }
}
