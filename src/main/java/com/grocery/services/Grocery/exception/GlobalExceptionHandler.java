package com.grocery.services.Grocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(groceryItemNotFoundException.class)
    public ResponseEntity<ApiRespionce> itemnotavilableException(groceryItemNotFoundException ex){
        String message = ex.getMessage();
        ApiRespionce apiRespionce= ApiRespionce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(apiRespionce,HttpStatus.NOT_FOUND);
    }
}
