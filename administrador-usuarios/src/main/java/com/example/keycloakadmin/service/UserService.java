package com.example.keycloakadmin.service;

import com.example.keycloakadmin.model.User;
import com.example.keycloakadmin.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public User findUserById(String id){return repository.findById(id);}
    public User deleteUserById(String id){return repository.deleteUserById(id);}
}
