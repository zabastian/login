package com.example.demo.response;

import lombok.Getter;

@Getter
public class MuLoginResponseDto {

    private final Long userId;
    private final String token;

//    public MuLoginResponseDto(String username) {
//        this.username = username;
//    }

    public MuLoginResponseDto(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

}
