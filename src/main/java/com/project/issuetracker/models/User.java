package com.project.issuetracker.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public class User {

    @Id
    private Integer id;

    private String email;

    private String password;

    private String name;

    private Integer role;

    private List<Project> projects;

    private List<Ticket> tickets;

}
