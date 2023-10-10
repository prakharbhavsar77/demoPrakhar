package com.example.prakhar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.prakhar.DTO.ApiResponse;


@ControllerAdvice
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<ApiResponse> resouceNotFoundExceptionHandler(ResouceNotFoundException ex)
	{
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.NOT_FOUND);
		
		
		
	}

}
