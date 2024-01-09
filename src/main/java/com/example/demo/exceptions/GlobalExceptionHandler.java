package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(CourseNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public ResponseEntity<ErrorModel> handleCourseNotFoundException(CourseNotFoundException ex){
		ErrorModel errorModel = new ErrorModel(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),ex.getMessage());
		return new ResponseEntity<>(errorModel,HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  public ResponseEntity<ErrorModel>handleGenericException(Exception ex){
		  ErrorModel errorModel = new ErrorModel(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value(),
				  HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),"InternalServer Error");
		  return new ResponseEntity<>(errorModel,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	

}
