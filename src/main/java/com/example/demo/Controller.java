package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class Controller {
	@Autowired
    private UserService userService;

	@GetMapping("/api/courses")
	public List<Course> getCourses() {
		return Arrays.asList(new Course(1, "React Basics"), new Course(2, "Advanced JavaScript"),
				new Course(3, "Backend with Node.js"));
	}
	@PostMapping("/api/login")
	public User login(@RequestBody User loginRequest) {
		return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
    }

	// Kurs-Klasse als inner class oder in einer separaten Datei
}
