package com.example.demo.authSessionLogin.controller;

import com.example.demo.authSessionLogin.dto.MemberLoginRequestDto;
import com.example.demo.authSessionLogin.dto.MemberLoginResponseDto;
import com.example.demo.authSessionLogin.dto.MemberRegisterRequestDto;
import com.example.demo.authSessionLogin.dto.MemberRegisterResponseDto;
import com.example.demo.authSessionLogin.service.AuthSessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class AuthSessionController {

    private final AuthSessionService authSessionService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterResponseDto> registerMemberApi(@RequestBody MemberRegisterRequestDto memberRegisterRequestDto){
//        log.info(memberRegisterRequestDto.getEmail());
        log.info(Integer.toString((9*600)/16));
        MemberRegisterResponseDto memberRegisterResponseDto = authSessionService.registerMember(memberRegisterRequestDto);
        return ResponseEntity.ok(memberRegisterResponseDto);

    }

    public MemberLoginResponseDto loginMemberApi(@RequestBody MemberLoginRequestDto memberLoginRequestDto, HttpServletRequest request) {
        MemberLoginResponseDto memberLoginResponseDto = authSessionService.loginMember(memberLoginRequestDto, request);
        return memberLoginResponseDto;
    }
}
