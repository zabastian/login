package com.example.demo.response;

import lombok.Getter;

@Getter
public class MuRegisterResponseDto {

    private Long userId;

    public MuRegisterResponseDto(Long userId) {
        this.userId = userId;
    }

    protected MuRegisterResponseDto() {}

}
