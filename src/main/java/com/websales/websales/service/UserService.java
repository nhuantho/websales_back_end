package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.User;
import com.websales.websales.responsitory.UserResponitory;

@Service
public class UserService {
    @Autowired
    private UserResponitory responitory;

    public User saveUser(User client){
        return responitory.save(client);
    }

    public List<User> saveUsers(List<User> clients){
        return responitory.saveAll(clients);
    }

    public List<User> getUsers(){
        return responitory.findAll();
    }

    public User getUserById(int id){
        return responitory.findById(id).orElse(null);
    }
    
    public List<User> getUserByUsername(String username) {
    	return responitory.findByUsername(username);
    }

    public String deleteUser(int id){
        responitory.deleteById(id);
        return "User removed " + id;
    }

    public User updateUser(User client){
        User existingUser = responitory.findById(client.getId()).orElse(null);
        existingUser.setFullname(client.getFullname());
        existingUser.setDob(client.getDob());
        existingUser.setGender(client.getGender());
        existingUser.setPhone(client.getPhone());
        existingUser.setAddress(client.getAddress());
        existingUser.setUsername(client.getUsername());
        existingUser.setPassword(client.getPassword());
        existingUser.setIsAdmin(client.getIsAdmin());
        existingUser.setNote(client.getNote());
        return responitory.save(existingUser);
    }
}
