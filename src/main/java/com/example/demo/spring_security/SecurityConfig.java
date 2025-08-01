package com.example.demo.spring_security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // HttpSecurity 설정 중 예외 가능성을 선언한 것
        return http
                .csrf(csrf -> csrf.disable()) // Session을 쓰지 않는 구조에서는 CSRF 토큰이 필요 없으므로 꺼줍
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 매 요청마다 JWT로 인증처리하니 서버는 로그인 상태 기억하지 않음
                )
                .formLogin(login -> login.disable()) // 기본 제공되는 form 기반 로그인 화면을 사용하지 않겠다
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/mu/login", "/mu/register").permitAll()
                    .requestMatchers("/homePage/controller").hasRole("USER") // "ROLE_USER" 권한을 갖고 있어야 함
                    .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

      /*  Spring Security 필터 체인에서의 순서 예시
        SecurityContextPersistenceFilter
↓
        jwtAuthenticationFilter   ← 커스텀 JWT 필터 (사용자 인증 정보를 SecurityContext에 세팅)
↓
        UsernamePasswordAuthenticationFilter   ← 여기선 꺼둠(formLogin().disable())
↓
        FilterSecurityInterceptor

        즉,
        UsernamePasswordAuthenticationFilter는 기본 로그인 처리 필터이다.
        이 필터는 이미 로그인한 사용자인지를 판단하고 인증 처리하는것 이기 때문에 JWT 토큰으로 인증을 사용하기위해선 필수이다.
*/
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            throw new UsernameNotFoundException("JWT 기반 인증 구조이므로 userDetailsService는 사용하지 않음");
        };
    }
    // JWT기반 로그인이기에 .formLogin(login -> login.disable()) 와 같이 기본 로그인 설정 사용안하겠다 해줘야 한다.
}
