package com.api.jwtsecurity.security;

import com.api.jwtsecurity.data.UserDetailsData;
import com.api.jwtsecurity.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTFilterAuthentication extends UsernamePasswordAuthenticationFilter {

    private static final int TOKEN_EXPIRED = 2_592_000; //expira em 10minutos, 1º ver se vai usar mesmo 1.1º se for usar mudar esse tempo ou não por
    protected static final String TOKEN_PASSWORD = "13ac8031-0f82-461d-97e0-1c9a50fbc892"; //por em arquivo de config ou variavel de ambiente
    private final AuthenticationManager authenticationManager;

    public JWTFilterAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getLogin(),
                    user.getPassword(),
                    user.getCargos()//bota aqui as permissões do usuário
            ));
        } catch (IOException e) {
            throw new RuntimeException("Erro na autenticação do usuário", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetailsData userDetailsData = (UserDetailsData) authResult.getPrincipal();

        String token = JWT.create().withSubject(userDetailsData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRED))
                .withClaim("roles", userDetailsData.getAuthorities())
                .sign(Algorithm.HMAC512(TOKEN_PASSWORD));

        response.getWriter().write(token);
        response.getWriter().flush();

    }
}
