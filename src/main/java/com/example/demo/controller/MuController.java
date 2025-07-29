package com.example.demo.controller;

import com.example.demo.request.MuLoginRequestDto;
import com.example.demo.request.MuLogoutRequestDto;
import com.example.demo.request.MuRegisterRequestDto;
import com.example.demo.response.MuLoginResponseDto;
import com.example.demo.response.MuRegisterResponseDto;
import com.example.demo.service.MuService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/mu")
    @RequiredArgsConstructor
    @Slf4j
    public class MuController {

        private final MuService muService;

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
    }
