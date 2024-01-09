package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.exceptions.CourseNotFoundException;
@SuppressWarnings("unused")
public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse( Long CourseId);
	public Course createCourse(Course cource);
	public Course updateCourse(Course cource);
	public void deleteCourse(Long parseLong);
	
	
		
	}

