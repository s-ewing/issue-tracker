package com.project.issuetracker.controllers;

import com.project.issuetracker.models.Project;
import com.project.issuetracker.repositories.ProjectRepository;
import com.project.issuetracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/projects")
    public Project createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @PutMapping("/projects/project/{projectId}/adduser")
    public Project addUserToProject(@PathVariable Integer projectId, @RequestParam Integer userId){
        return projectService.addUser(projectId, userId);
    }


}
