package com.fetulhak.controllerAdvice_demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionObject {
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;
    public ExceptionObject(String message, HttpStatus httpStatus) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.httpStatus = httpStatus;
    }

}
