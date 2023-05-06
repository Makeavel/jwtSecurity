package com.api.jwtauth.security;

import com.api.jwtauth.services.impl.UserServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private JWTService jwtService;
    private UserServiceImpl userService;

    public JWTAuthenticationFilter(JWTService jwtService, UserServiceImpl userService){
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer")){
            String token = authorization.split(" ")[1];
            boolean isValid = jwtService.validateToken(token);

            if(isValid){
                String userLogin = jwtService.getLogin(token);
                UserDetails user = userService.loadUserByUsername(userLogin);
                UsernamePasswordAuthenticationToken authUser = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                System.out.println(user.getAuthorities());
                authUser.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authUser);
            }
        }

        filterChain.doFilter(request, response);
    }
}
