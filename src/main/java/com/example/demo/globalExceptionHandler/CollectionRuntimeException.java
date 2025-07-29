package com.example.demo.globalExceptionHandler;

public class    CollectionRuntimeException {

    public static final String USER_NOT_FOUND = "아이디가 없습니다.";

    public static UserRuntimeException userNotFoundException(Long userId) {
        return new UserRuntimeException(USER_NOT_FOUND + userId);
    }


}
