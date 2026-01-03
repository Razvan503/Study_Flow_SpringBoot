package org.example.study.Controllers;

import org.example.study.Models.DTO.SubjectRequest;
import org.example.study.Models.JpaModels.Chapter;
import org.example.study.Models.JpaModels.Subject;
import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.ChapterRepository;
import org.example.study.Repository.SubjectRepository;
import org.example.study.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.study.Models.DTO.ChapterRequest;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddCourse {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @PostMapping("/addCourse")
    public ResponseEntity<Void> AddCourse(@RequestBody SubjectRequest subjectRequest){
        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();

        String username = authenticated.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.get();

        Subject subject = new Subject();
        subject.setUser(user);
        subject.setName(subjectRequest.getName());
        subject.setDescription(subjectRequest.getDescription());


        subjectRepository.save(subject);

        ArrayList<ChapterRequest> chapters= (ArrayList<ChapterRequest>) subjectRequest.getChapters();
        for(ChapterRequest c : chapters){
            Chapter chapter = new Chapter();
            chapter.setTitle(c.getName());
            chapter.setTime(c.getDuration());
            chapter.setSubject(subject);
            chapterRepository.save(chapter);
            subject.addChapter(chapter);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
