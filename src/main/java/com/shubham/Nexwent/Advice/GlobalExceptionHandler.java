package com.shubham.Nexwent.Advice;

import com.shubham.Nexwent.Exception.AttendeeNotFoundException;
import com.shubham.Nexwent.Exception.EventNotFoundException;
import com.shubham.Nexwent.Exception.TicketsNotFoundException;
import com.shubham.Nexwent.Exception.VenueNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(AttendeeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(EventNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketsNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(TicketsNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VenueNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(VenueNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
