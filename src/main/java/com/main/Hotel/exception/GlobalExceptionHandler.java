package com.main.Hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings("unchecked")
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> notFoundExceptionHandler(ResourceNotFoundException ex) {
		Map m = new HashMap<>();
		m.put("message", ex.getMessage());
		m.put("success", false);
		m.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(m);
	}
}
