package org.example.study.Controllers;

import org.example.study.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.study.Models.RegisterRequest;
import org.example.study.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Register {

    private final UserRepository userRepository;

    @Autowired
    public Register(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String signUp(@RequestBody RegisterRequest register){
        String username = register.getUsername();
        Optional<User> existingUser = userRepository.findByUsername(username);
        
        if(existingUser.isPresent()){
            return "Username already taken";
        } else {
            User user = new User(
                register.getUsername(),
                register.getFullname(),
                register.getEmail(),
                register.getPassword(), // Note: Password should ideally be encoded
                "user" // Default role
            );
            userRepository.save(user);
            return "User registered successfully";
        }
    }
}
