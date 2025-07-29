package com.example.demo.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserRuntimeException.class)
    public ResponseEntity<ErrorResponse> HandleNotFoundException(UserRuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse("User Not Found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // 이 과정애소 jacksonlibrary가 작동
    }

}
/*@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserRuntimeException.class)
    public ResponseEntity<String> HandleNotFoundException(UserRuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}*/
