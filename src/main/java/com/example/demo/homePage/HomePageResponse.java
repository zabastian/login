package com.example.demo.homePage;

import lombok.Getter;

@Getter
public class HomePageResponse {
    private String message;
    private Long userId;

    public HomePageResponse(String message, Long userId) {
        this.message = message;
        this.userId = userId;
    }
}
