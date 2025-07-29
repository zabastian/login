package com.example.demo.authSessionLogin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRegisterResponseDto {
    private String message;
    private Long memberId;

}
