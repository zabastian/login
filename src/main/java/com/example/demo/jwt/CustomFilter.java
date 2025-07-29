package com.example.demo.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component

public class CustomFilter implements Filter {
    private final TokenService tokenService;

    public CustomFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private static final List<String> WHITELIST = Arrays.asList("/mu/register", "/mu/login");

    private boolean isWhiteList(String link) { return WHITELIST.contains(link); }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String requestURI = httpRequest.getRequestURI();

        if (isWhiteList(requestURI)) { //if (isWhitelist(requestURI))가 true면 실행하고, false면 실행 안 해!!!!!
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader("Authorization");

        //토큰검증
/*
        long userId = tokenService.verifyToken(token);
*/
        DecodedJWT decodedJWT = tokenService.verifyToken(token);
        Long userId = Long.parseLong(decodedJWT.getSubject());
        String role = decodedJWT.getClaim("role").asString();

        //유저 정보 추출
        request.setAttribute("userId", userId);
        request.setAttribute("userRole", role);

        chain.doFilter(request, response);

    }

}
