package com.example.demo.authSessionLogin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberLoginResponseDto {
    private String message;
    private String sessionId;
}
