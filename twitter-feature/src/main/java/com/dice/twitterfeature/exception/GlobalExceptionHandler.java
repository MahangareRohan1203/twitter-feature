package com.dice.twitterfeature.exception;

import com.dice.twitterfeature.response.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> unauthenticatedUserExceptionHandler(Exception exception) {
        System.out.println("In global handler");
        ErrorDetail detail = new ErrorDetail(exception.getMessage(), LocalDateTime.now());

        if (exception instanceof UserException) {
            return new ResponseEntity<>(detail, HttpStatus.UNAUTHORIZED);
        }
        if (exception instanceof RuntimeException) {
            return new ResponseEntity<>(detail, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }
}
