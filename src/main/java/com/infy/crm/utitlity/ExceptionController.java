package com.infy.crm.utitlity;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infy.crm.exception.StudentException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler
	public ResponseEntity<ResponseBody> handleStudentException(StudentException error) {
		ResponseBody err = new ResponseBody();
		err.setMessage(error.getMessage());
		err.setStatusCode(error.getStatus().value());
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ResponseBody>(err, error.getStatus());
	}

}
