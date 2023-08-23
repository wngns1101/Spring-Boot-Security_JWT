package com.example.SpringSecurityJWT.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().cors().disable()
                .authorizeHttpRequests((authz) -> authz
                        // 컨트롤러에서 파일 화일명을 return하여 페이지를 이동하는 경우 추가해야한다.
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/", "/error", "/sign-up", "/sign-in","/swagger-ui.html","/swagger-ui/**","/api-docs/**", "/v3/**").permitAll()
                        .anyRequest().authenticated() // 어떠한 요청이라도 인증필요
                )
                .sessionManagement(
                        // 세션을 사용하지 않으므로 STATELESS 설정
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }

    // 암호화 모듈
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
