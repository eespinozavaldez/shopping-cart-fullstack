package com.deloitte.shoppingcart.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
		        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
        
        
	@ExceptionHandler(ProductNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleProductNotFoundException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(OrderNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleOrderNotFoundException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(OrderRunOffInventoryException.class)
	  public final ResponseEntity<ErrorDetails> handleOrderRunOffInventoryException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
}
