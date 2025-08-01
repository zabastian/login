package com.example.demo.homePage;

import com.example.demo.spring_security.CustomUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HomePageResponse> HomePage(
            @AuthenticationPrincipal CustomUserPrincipal principle,
            @RequestBody HomePageRequest homePageRequest
    ) {

        Long userId = principle.getUserId();
        String role = principle.getRole();

        HomePageResponse homePageResponse = homePageService.HomepageWelcome(homePageRequest, userId, role);
        return ResponseEntity.ok(homePageResponse);
    }
}

//원래 jwt이용했을 때의 코드
/*
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
*/
