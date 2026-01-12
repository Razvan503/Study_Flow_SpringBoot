package org.example.study.Controllers;

import org.example.study.Models.JpaModels.User;
import org.example.study.SecurityConfigs.jwt.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.example.study.Models.Register.RegisterRequest;
import org.example.study.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Register {

    private final UserRepository userRepository;

    @Autowired
    private TokenCreator tokenCreator;

    public Register(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest register){
        Optional<User> UserExists = userRepository.findByUsername(register.getUsername());
        if(UserExists.isPresent()){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
           User user = new User(register.getUsername(), register.getFullname(),register.getEmail(),passwordEncoder.encode(register.getPassword()),"ROLE_USER");
           userRepository.save(user);

           String token = tokenCreator.createToken(register.getUsername(),"user");
           HttpHeaders headers = new HttpHeaders();

           ResponseCookie cookie = ResponseCookie.from("jwt",token)
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .sameSite("Strict")
                    .build();

           headers.add(HttpHeaders.SET_COOKIE,cookie.toString());

          return new ResponseEntity<>(headers,HttpStatus.OK);
        }

    }
}
