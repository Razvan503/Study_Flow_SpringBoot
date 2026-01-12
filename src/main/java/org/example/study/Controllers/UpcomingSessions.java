package org.example.study.Controllers;

import org.example.study.Models.DTO.UpcomingSessionsDTO;
import org.example.study.Models.JpaModels.Session;
import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.StudySessionRepository;
import org.example.study.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UpcomingSessions {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudySessionRepository sessionRepository;

    @GetMapping("/upcomingSession")
    public List<UpcomingSessionsDTO> upcomingSessions() {
        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticated.getName();

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            return new ArrayList<>();
        }
        User user = userOptional.get();

        List<Session> allSessions = sessionRepository.findByEmail(user.getEmail());
        LocalDateTime now = LocalDateTime.now();

        // 1. Filter: Find sessions that are in the future
        List<Session> futureSessions = new ArrayList<>();
        for (Session session : allSessions) {
            if (session.getSessionTime().isAfter(now)) {
                futureSessions.add(session);
            }
        }

        // 2. Sort: Order by session time
        futureSessions.sort(Comparator.comparing(Session::getSessionTime));

        // 3. Limit & Map: Take the first 3 and convert to DTO
        List<UpcomingSessionsDTO> result = new ArrayList<>();

        // We loop up to 3, but ensure we don't go out of bounds if there are fewer than 3 sessions
        int limit = Math.min(futureSessions.size(), 3);

        for (int i = 0; i < limit; i++) {
            Session session = futureSessions.get(i);
            result.add(new UpcomingSessionsDTO(session.getSubject_name()));
        }

        return result;
    }
}