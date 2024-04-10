package com.comp313.bloodlink.controller;

import com.comp313.bloodlink.model.User;
import com.comp313.bloodlink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("users") // Standardized API path
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        System.out.println("Fetching all users");
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") final String userId) {
        System.out.println("Fetching user with ID: " + userId);
        return userService.getById(userId)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateById(@PathVariable("userId") final String userId, @RequestBody final User user) {
        System.out.println("Updating user info for ID: " + userId);
        try {
            User updatedUser = userService.update(userId, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User formData) {
        System.out.println("Registering new user");
        User savedUser = userService.save(formData);
        return ResponseEntity.ok(savedUser); // Consider using ResponseEntity.created(URI) for creation
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginDetails) {
        System.out.println("User login attempt");
        User user = userService.authenticate(loginDetails.getEmail(), loginDetails.getPassword());
        if (user != null) {
            // Authentication successful
            return ResponseEntity.ok(user); // Return user details in JSON format
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"error\": \"Invalid credentials\"}");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") final String userId) {
        System.out.println("Deleting user with ID: " + userId);
        try {
            userService.delete(userId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
