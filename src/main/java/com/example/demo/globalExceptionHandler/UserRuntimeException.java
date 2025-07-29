package com.example.demo.globalExceptionHandler;

public class UserRuntimeException extends RuntimeException{
    public UserRuntimeException(String message) {
        super(message);
    }
}
