package org.example.study.Controllers;

import org.example.study.Models.DTO.AccountDTO;
import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/account")
    public ResponseEntity<AccountDTO> accountResponse(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.get();

        AccountDTO accountDTO = new AccountDTO(user.getUsername(),user.getEmail(),user.getFullname());

        return ResponseEntity.ok(accountDTO);
    }
}
