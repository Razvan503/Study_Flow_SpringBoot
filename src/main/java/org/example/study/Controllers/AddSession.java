package org.example.study.Controllers;

import org.example.study.Models.DTO.SessionRequest;
import org.example.study.Models.JpaModels.Session;
import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.StudySessionRepository;
import org.example.study.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AddSession {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudySessionRepository sessionRepository;

   @PostMapping("/addSession")
    public ResponseEntity<Void> addSession(@RequestBody SessionRequest sessionRequest){
       Session session = new Session();

       String date = sessionRequest.getDate();
       String time = sessionRequest.getTime();

       String combinedDate = date + " " + time;
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

       LocalDateTime dateTime = LocalDateTime.parse(combinedDate,formatter);

       Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
       String username = authenticated.getName();
       Optional<User> userOptional = userRepository.findByUsername(username);
       User user = userOptional.get();

       session.setEmail(user.getEmail());
       session.setSessionTime(dateTime);
       session.setIs_completed(false);
       session.setSubject_name(sessionRequest.getSubject());
       session.setDuration(sessionRequest.getDuration());

       sessionRepository.save(session);

       return new ResponseEntity<>(HttpStatus.OK);
   }
}
