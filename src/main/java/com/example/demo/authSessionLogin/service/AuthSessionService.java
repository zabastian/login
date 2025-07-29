package com.example.demo.authSessionLogin.service;

import com.example.demo.jwt.PasswordEncoder;
import com.example.demo.authSessionLogin.dto.MemberLoginRequestDto;
import com.example.demo.authSessionLogin.dto.MemberLoginResponseDto;
import com.example.demo.authSessionLogin.dto.MemberRegisterRequestDto;
import com.example.demo.authSessionLogin.dto.MemberRegisterResponseDto;
import com.example.demo.authSessionLogin.repository.MemberRepository;
import com.example.demo.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthSessionService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

//    public AuthSessionService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public MemberRegisterResponseDto registerMember(MemberRegisterRequestDto memberRegisterRequestDto) {
        // 1. request에서 정보 가져오기
        String email = memberRegisterRequestDto.getEmail();
        String password = memberRegisterRequestDto.getPassword();
        // 이메일 존재 여부 확인
        boolean flag = memberRepository.existsByEmail(email);
        if (flag) {
            throw new RuntimeException("이미 존재하는 이메일 입니다.");
        }
        // 비밀번호 암호하 하기
        String encodedPassword = passwordEncoder.encode(password);
        // 2. 암호화 한 비밀번호 Member에 넣기
        Member newMember = new Member(email, encodedPassword);
        // 3. Member에 값 저장하기
        Member savedMember = memberRepository.save(newMember);

        String message = "회원 가입에 성공했습니다.";
        Long memberId = savedMember.getId();

        //message와 memberId를 가져와서 응답값에 넣어주기
        MemberRegisterResponseDto memberRegisterResponseDto = new MemberRegisterResponseDto(message, memberId);

        return memberRegisterResponseDto;

    }

    public MemberLoginResponseDto loginMember(MemberLoginRequestDto memberLoginRequestDto, HttpServletRequest request) {

        // 1. request로 속성값 가져오기 (로그인 시 필요한 비밀번호)
        String email = memberLoginRequestDto.getEmail();
        String password = memberLoginRequestDto.getPassword();

        // 2. DB에서 회원 조회하기(원래 저장되어 있는 password 를 가져온다.)
        Optional<Member> memberoptional = memberRepository.findByEmail(email);
        boolean flag = memberoptional.isEmpty();
        if (flag) {
            throw new RuntimeException("null값입니다.");
        }
        Member foundMember = memberoptional.get();

        // 3. 비밀번호 검증
        String foundPassword = foundMember.getPassword();
//        String foundPassword = memberoptional.get().getPassword();
        boolean flag1 = passwordEncoder.matches(password, foundPassword);
        if (!flag1) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다. ");
        }

        //Session 생성
        HttpSession session = request.getSession(); // session을 조회하거나 생성한다.
        session.setAttribute("memberId", foundMember.getId());

        session.setMaxInactiveInterval(10);

        String sessionId = session.getId();

        String message = "로그인이 완료 되었습니다.";

        MemberLoginResponseDto memberLoginResponseDto = new MemberLoginResponseDto(message, sessionId);
        return memberLoginResponseDto;


    }

}
