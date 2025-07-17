package com.smart.expense.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static com.smart.expense.tracker.constants.ApplicationConstants.INVALID_EMAIL;
import static com.smart.expense.tracker.constants.ApplicationConstants.USER_NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidEmailException(InvalidEmailException ex){

        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("error", INVALID_EMAIL);
        errorBody.put("status", HttpStatus.BAD_REQUEST.value());
        errorBody.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidUser(InvalidUserException ex){

        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("status", HttpStatus.BAD_REQUEST.value());
        errorBody.put("time", LocalTime.now());
        errorBody.put("message",ex.getMessage());
        errorBody.put("error", USER_NOT_FOUND);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

}
