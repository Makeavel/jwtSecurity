package com.api.jwtauth.services.impl;

import com.api.jwtauth.exceptions.InvalidPasswordException;
import com.api.jwtauth.repositories.UserRepository;
import com.api.jwtauth.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        //String[] roles = user.isAdmin() ? new String[] {"ADMIN", "USER"} : new String[]{"USER"};

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                //.roles(roles)
                .build();
        /*if(!username.equals("cicrano")){
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username("cicrano")
                .password(passwordEncoder.encode("123"))
                .roles("USER", "ADMIN")
                .build();*/
    }

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public UserDetails auth(User user){
        UserDetails existingUser = loadUserByUsername(user.getLogin());
        boolean passwordMatches = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());

        if(passwordMatches){
            return existingUser;
        }
        throw new InvalidPasswordException();
    }
}
