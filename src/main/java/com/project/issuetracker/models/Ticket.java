package com.project.issuetracker.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    private Integer id;
    private String title;
    private String description;
    private User submittedBy;
    private User assignedUser;
    private String status;
    private String priority;
    private String type;
    private Date createdAt;
    private Date updatedAt;
    private Project project;
    //Comments and attachments
}
