package com.example.demo.homePage;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homePage")
@RequiredArgsConstructor
public class HomePageController {

    private final HomePageService homePageService;

    @PostMapping("/controller")
    public ResponseEntity<HomePageResponse> HomePage(@RequestBody HomePageRequest homePageRequest, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        String role = (String) request.getAttribute("userRole");

        HomePageResponse homePageResponse = homePageService.HomepageWelcome(homePageRequest, userId, role);
        return ResponseEntity.ok(homePageResponse);
    }
}
