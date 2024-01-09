package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/api/v1")
public class MyController {
	//kind of AUTOWIRING for loose coupling and making service as a bean class and it is Dependency Injection
	@Autowired
	private CourseService Courseservice;
	// This is only a test Method
	@GetMapping("/Home")
	public String Home() {
		return "Welocme to Courses Application";
	}
	
	// Get List of Courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.Courseservice.getCourses();
	}
	//Get Course By CourseId
	@GetMapping("/courses/{CourseId}")
	public Course getCourse(@PathVariable String CourseId) {
		return this.Courseservice.getCourse(Long.parseLong(CourseId));
	}
	//Create a new Course 
	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course) {
	return this.Courseservice.createCourse(course);
}
	//update request for update course 
	@PutMapping("courses/{CourseId}")
	public Course updateCourse(@RequestBody Course course) {
		return this.Courseservice.updateCourse(course);
	}
	//Delete Request for Deleting the course
	@DeleteMapping("/courses/{CourseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseId) {
		try {
			this.Courseservice.deleteCourse(Long.parseLong(CourseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
