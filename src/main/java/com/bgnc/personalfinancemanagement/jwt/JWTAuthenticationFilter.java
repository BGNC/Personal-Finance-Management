package com.bgnc.personalfinancemanagement.jwt;

import com.bgnc.personalfinancemanagement.exception.BaseException;
import com.bgnc.personalfinancemanagement.exception.ErrorMessage;
import com.bgnc.personalfinancemanagement.exception.MessageType;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if(header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token=header.substring(7);

        try {
             String username = jwtService.getUsernameByToken(token);
             if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
                 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                 if(userDetails!=null && jwtService.isTokenValid(token)){
                     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                     authentication.setDetails(userDetails);
                     SecurityContextHolder.getContext().setAuthentication(authentication);
                 }

             }
    
        }
        catch(ExpiredJwtException ex) {
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED, ex.getMessage()));
        }
        catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
        }
        filterChain.doFilter(request, response);

    }
}
