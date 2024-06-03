package com.example.keycloakadmin.controller;


import com.example.keycloakadmin.model.User;
import com.example.keycloakadmin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
@GetMapping
public String yes(){
        return "Sector admin usuarios";
}
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<List<User>> findByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(service.findByUserName(userName));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id){
        return ResponseEntity.ok(service.findUserById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable String id){
        return ResponseEntity.ok(service.deleteUserById(id));
    }
}
