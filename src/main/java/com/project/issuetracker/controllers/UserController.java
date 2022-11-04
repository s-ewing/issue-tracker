package com.project.issuetracker.controllers;

import com.project.issuetracker.models.Project;
import com.project.issuetracker.models.User;
import com.project.issuetracker.repositories.UserRepository;
import com.project.issuetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @PutMapping("/users/user/{id}")
    public User updateUserRole(@PathVariable Integer userId, Integer role){
        return userService.setUserRole(userId, role);
    }

    @GetMapping("/users/{userId}/projects")
    public List<Project> getProjectsByUser(@PathVariable Integer userId){
        return userService.getProjectsByUser(userId);
    }


}
