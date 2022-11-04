package com.project.issuetracker.services;

import com.project.issuetracker.models.Project;
import com.project.issuetracker.models.Ticket;
import com.project.issuetracker.models.User;
import com.project.issuetracker.repositories.ProjectRepository;
import com.project.issuetracker.repositories.TicketRepository;
import com.project.issuetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    public Ticket createTicket(@Valid Ticket ticket, Integer projectId) throws NoSuchElementException {
        Project project = projectRepository.findById(projectId).orElseThrow(NoSuchElementException::new);
        project.assignProjectToTicket(ticket);
        projectRepository.save(project);
        return  ticketRepository.save(ticket);
    }

    public Ticket assignTicketToUser(Integer ticketId, Integer userId) throws NoSuchElementException {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(NoSuchElementException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        ticket.assignTicketToUser(user);
        userRepository.save(user);
        return ticketRepository.save(ticket);
    }
}
