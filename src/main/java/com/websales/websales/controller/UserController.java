package com.websales.websales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.websales.model.User;
import com.websales.websales.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User client){
        return service.saveUser(client);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> clients){
        return service.saveUsers(clients);
    }

    @GetMapping("/users")
    public List<User> findAlLUsers(){
        return service.getUsers();
    }
    
    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    
    @GetMapping("/userByUsername/{username}")
    public List<User> findUserByUsername(@PathVariable String username){
        return service.getUserByUsername(username);
    }

    @PutMapping("/updateUser")
    public User update(@RequestBody User client){
        return service.updateUser(client);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
}