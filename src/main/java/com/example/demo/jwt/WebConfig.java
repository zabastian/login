/*
package com.example.demo.jwt;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WebConfig {
    private final TokenService tokenService;

    @Bean
    public FilterRegistrationBean loginfilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CustomFilter(tokenService));
        // 필터 실행 순서 설정 (숫자가 낮을수록 먼저 실행)
        filterFilterRegistrationBean.setOrder(1);

        // 어떤 URL에 적용할지 설정
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }

}*/
