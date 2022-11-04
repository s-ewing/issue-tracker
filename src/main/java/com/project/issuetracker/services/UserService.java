package com.project.issuetracker.services;

import com.project.issuetracker.models.Project;
import com.project.issuetracker.models.User;
import com.project.issuetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(@Valid User newUser){
        return userRepository.save(newUser);
    }

    public User setUserRole(Integer userId, Integer role) throws NoSuchElementException {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        user.setRole(role);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User editUser(Integer userId, User updatedUser) throws NoSuchElementException {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

    public List<Project> getProjectsByUser(Integer userId) throws NoSuchElementException {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return user.getProjects();
    }
}
