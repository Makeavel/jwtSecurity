package com.api.jwtauth.controllers;

import com.api.jwtauth.exceptions.InvalidPasswordException;
import com.api.jwtauth.DTO.CredentialsDTO;
import com.api.jwtauth.DTO.TokenDTO;
import com.api.jwtauth.security.JWTService;
import com.api.jwtauth.models.User;
import com.api.jwtauth.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
        /*String token = jwtService.generateToken(user);
        System.out.println(token);
        boolean isValidToken = jwtService.validateToken(token);
        System.out.println("Token Válido: " + isValidToken);
        System.out.println(jwtService.getLogin(token));
        return null;*/
    }

    @PostMapping("/auth")
    public TokenDTO login(@RequestBody CredentialsDTO credentials) throws Exception {
        try {
            User attemptUser = User.builder().login(credentials.getLogin()).password(credentials.getPassword()).build();
            UserDetails authUser = userService.auth(attemptUser);
            String token = jwtService.generateToken(attemptUser);
            User loggedUser = userService.getUserByLogin(attemptUser.getLogin());
            return new TokenDTO(loggedUser, token);
        } catch (UsernameNotFoundException | InvalidPasswordException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
    }
}
