package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}