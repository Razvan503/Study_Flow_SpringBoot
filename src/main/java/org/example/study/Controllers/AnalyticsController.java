package org.example.study.Controllers;

import org.example.study.Models.Analytics;
import org.example.study.Models.JpaModels.Session;
import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.StudySessionRepository;
import org.example.study.Repository.SubjectRepository;
import org.example.study.Repository.UserRepository;
import org.hibernate.dialect.function.array.AbstractArrayTrimFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AnalyticsController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudySessionRepository sessionRepository;

    @GetMapping("/analytics")
    public ResponseEntity<Analytics> analytics(){

        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticated.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.get();

        ArrayList<Session> sessions = (ArrayList<Session>) sessionRepository.findByEmail(user.getEmail());
        Integer studySessionSum = 0;
        Integer completedSessions = 0;
        ArrayList<String> names = new ArrayList<>();

        int session_counter = 0;
        for(Session s : sessions){
            studySessionSum += s.getDuration();
            if(s.getIs_completed()){
                completedSessions += 1;
            }
            if(session_counter < 5){
                names.add(s.getSubject_name());
                session_counter++;
            }
        }

        Analytics analytics = new Analytics(studySessionSum,studySessionSum/7,completedSessions,names);

        return ResponseEntity.ok(analytics);
    }
}
