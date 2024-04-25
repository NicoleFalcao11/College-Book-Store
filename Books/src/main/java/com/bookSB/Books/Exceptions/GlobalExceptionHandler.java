package com.bookSB.Books.Exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ControllerAdvice
	public class StudentRestExceptionHandler {
	      //Add exception handling code
		@ExceptionHandler
	    public ResponseEntity<StudentResponse> handleException(StudentNotFoundException exc)
	    {
	   	 //create a StudentErrorResponse
	   	 StudentResponse error = new StudentResponse();
	   	 error.setStatus(HttpStatus.NOT_FOUND.value());
	   	 error.setMessage(exc.getMessage());
	   	 error.setTimestamp(System.currentTimeMillis());
	   	 //return ResponseEntity
	   	 return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler
	    public ResponseEntity<StudentResponse> handleException(Exception exc)
	    {
	   	 //create a StudentErrorResponse
	   	 StudentResponse error = new StudentResponse();
	   	 error.setStatus(HttpStatus.BAD_REQUEST.value());
	   	 error.setMessage("InValid Input ! Please Enter Integer Value and not a String");
	   	 error.setTimestamp(System.currentTimeMillis());
	   	 //return ResponseEntity
	   	 return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
	    }
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
	    Map<String, String> resp = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String message = error.getDefaultMessage();
	        resp.put(fieldName, message);
	    });
	    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}


}
}
	
