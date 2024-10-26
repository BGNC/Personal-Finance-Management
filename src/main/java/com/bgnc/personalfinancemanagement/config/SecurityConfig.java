package com.bgnc.personalfinancemanagement.config;

import com.bgnc.personalfinancemanagement.handler.AuthEntryPoint;
import com.bgnc.personalfinancemanagement.jwt.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final AuthEntryPoint authEntryPoint;;
    private final AuthenticationProvider authenticationProvider;

    public static final String register = "/register";
    public static final String login = "/login";
    public static final String logout = "/logout";
    public static final String authenticate="/authenticate";
    public static final String REFRESH_TOKEN = "/refreshToken";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize->
                        authorize
                                .requestMatchers(register,
                                        login,
                                        logout,
                                        authenticate,
                                        REFRESH_TOKEN)
                                .permitAll()
                                .anyRequest().authenticated())
                .exceptionHandling(exception->exception.authenticationEntryPoint(authEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
