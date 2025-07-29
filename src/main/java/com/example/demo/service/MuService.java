package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.jwt.PasswordEncoder;
import com.example.demo.jwt.TokenService;
import com.example.demo.repository.MuRepository;
import com.example.demo.request.MuLoginRequestDto;
import com.example.demo.request.MuRegisterRequestDto;
import com.example.demo.response.MuLoginResponseDto;
import com.example.demo.response.MuRegisterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuService {

    private final MuRepository muRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public MuRegisterResponseDto muRegisterService(MuRegisterRequestDto muRegisterRequestDto) {

        if(muRepository.existsByUsername(muRegisterRequestDto.getUsername())){
            throw new IllegalArgumentException("이미 존재하는 이메일 입니다.");
        }
        // User 생성자 가져와서 request와 연결하기
        String encodedPassword = passwordEncoder.encode(muRegisterRequestDto.getPassword());

        User user = new User(muRegisterRequestDto.getUsername() ,encodedPassword, muRegisterRequestDto.getUserRole());

        User savedUser = muRepository.save(user);

        return new MuRegisterResponseDto(savedUser.getId());
    }

    public MuLoginResponseDto muLoginService(MuLoginRequestDto muLoginRequestDto) {

        User saved2user = muRepository.findByUsername(muLoginRequestDto.getUsername()).
                orElseThrow(() -> new RuntimeException("유저 이름 잘못 기입하셨습니다."));

        if(passwordEncoder.matches(muLoginRequestDto.getPassword(),saved2user.getPassword())) {
            Long userId = saved2user.getId();
            String token = tokenService.createToken(userId, saved2user.getUserRole());

            return new MuLoginResponseDto(userId, token);
        }
        throw new IllegalArgumentException("비밀번호가 다릅니다.");
    }


}

