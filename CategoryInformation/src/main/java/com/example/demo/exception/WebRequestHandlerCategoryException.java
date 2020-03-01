package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class WebRequestHandlerCategoryException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		ResponseException exp = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> CategoryNotFoundException( CategoryNotFoundException ex, WebRequest request) {
		ResponseException exp = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exp, HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException exp = new ResponseException(new Date(), ex.getMessage(), ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exp, HttpStatus.BAD_REQUEST);
	}

}
