package com.example.demo.request;

import com.example.demo.entity.UserRole;
import lombok.Getter;

@Getter
public class MuRegisterRequestDto {

    private String username;
    private String password;
    private UserRole userRole;


}
