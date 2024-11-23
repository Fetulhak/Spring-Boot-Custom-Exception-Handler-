package com.fetulhak.controllerAdvice_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<ExceptionObject> CustomerApiExceptionHandler(CustomerNotFoundException customerNotFoundException){

        return ResponseEntity.ok(new ExceptionObject(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND));

    }
}
