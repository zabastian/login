package com.example.demo.controller;

import com.example.demo.jwt.TokenService;
import com.example.demo.request.MuLoginRequestDto;
import com.example.demo.request.MuRegisterRequestDto;
import com.example.demo.response.MuLoginResponseDto;
import com.example.demo.response.MuRegisterResponseDto;
import com.example.demo.service.MuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/mu")
    @RequiredArgsConstructor
    @Slf4j
    public class MuController {

        private final MuService muService;
        private final TokenService tokenService;

        @PostMapping("/register")
        public ResponseEntity<MuRegisterResponseDto> RegisterController(@RequestBody MuRegisterRequestDto muRegisterRequestDto) {
            MuRegisterResponseDto muRegisterResponseDto = muService.muRegisterService(muRegisterRequestDto);
            return ResponseEntity.ok(muRegisterResponseDto);
        }

        @PostMapping("/login")
        public ResponseEntity<MuLoginResponseDto> LoginController(@RequestBody MuLoginRequestDto muLoginRequestDto) {
            MuLoginResponseDto muLoginResponseDto = muService.muLoginService(muLoginRequestDto);
            return ResponseEntity.ok(muLoginResponseDto);
        }

//        @PostMapping("/logout/")
//        public ResponseEntity<Void> LogoutController(@RequestHeader("Authorization") String token) {
//            return ResponseEntity.ok().build();
//        }

//        @PostMapping("/logout")
//        public ResponseEntity<Void> logout(HttpServletRequest request) {
//            String header = request.getHeader("Authorization");
//            if (header != null && header.startsWith("Bearer ")) {
//                String token = header.substring(7);
//                tokenService.blacklistToken(token); // 예: Redis에 저장
//                log.info("로그아웃 - 블랙리스트 등록 완료");
//            }
//            return ResponseEntity.ok().build();
//        }
    }
