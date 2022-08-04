package com.examly.springapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException exception){
		return new ResponseEntity<>("Exception occured: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
