package com.project.issuetracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<User> assignedUsers = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<Ticket> tickets;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    //utility
    public void assignProjectToUser(User user){
        this.assignedUsers.add(user);
        user.getProjects().add(this);
    }

    public void assignProjectToTicket(Ticket ticket) {
        this.tickets.add(ticket);
        ticket.setProject(this);
    }

}
