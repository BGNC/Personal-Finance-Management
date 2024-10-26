package com.bgnc.personalfinancemanagement.config;

import com.bgnc.personalfinancemanagement.exception.BaseException;
import com.bgnc.personalfinancemanagement.exception.ErrorMessage;
import com.bgnc.personalfinancemanagement.exception.MessageType;
import com.bgnc.personalfinancemanagement.model.User;
import com.bgnc.personalfinancemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
public class AppConfig {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<User> optUser = userRepository.findByUsername(username);
                if(optUser.isEmpty()){
                    throw new BaseException(new ErrorMessage<>(MessageType.USERNAME_NOT_FOUND_EXCEPTION,username));
                }
                return optUser.get();
            }
        };

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
