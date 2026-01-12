package org.example.study.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.example.study.Models.DTO.ChapterCompletedDTO;
import org.example.study.Models.DTO.ChapterRequest;
import org.example.study.Models.JpaModels.Chapter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompleteChapter {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ChapterRepository chapterRepository;

	@PostMapping("/completeChapter")
	public ResponseEntity<Void> ChapterResponse(@RequestBody ChapterRequest chapterRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String username = authentication.getName();
		String subjectName = chapterRequest.getSubject();

		ArrayList<Chapter> chapters = (ArrayList<Chapter>) chapterRepository
				.findBySubject_Name_AndSubject_User_Username(subjectName, username);
		for (Chapter c : chapters) {
			if (c.getTitle().equals(chapterRequest.getName())) {
				c.setIsComplete(true);
				chapterRepository.save(c);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}
}
