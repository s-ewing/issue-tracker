package com.project.issuetracker.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Project {
    @Id
    private Integer id;
    private String name;
    private String description;
    private List<User> assignedUsers;
    private List<Ticket> tickets;
}
