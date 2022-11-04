package com.project.issuetracker.services;

import com.project.issuetracker.models.Project;
import com.project.issuetracker.models.Ticket;
import com.project.issuetracker.models.User;
import com.project.issuetracker.repositories.ProjectRepository;
import com.project.issuetracker.repositories.TicketRepository;
import com.project.issuetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    public Project createProject(@Valid Project project) {
        return projectRepository.save(project);
    }

    public Project addUser(Integer projectId, Integer userId) throws NoSuchElementException {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Project project = projectRepository.findById(projectId).orElseThrow(NoSuchElementException::new);
        project.assignProjectToUser(user);
        userRepository.save(user);
        return projectRepository.save(project);
    }


}
