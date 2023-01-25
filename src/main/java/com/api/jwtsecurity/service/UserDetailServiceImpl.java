package com.api.jwtsecurity.service;

import com.api.jwtsecurity.data.UserDetailsData;
import com.api.jwtsecurity.model.User;
import com.api.jwtsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findUserByLogin(username));
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuario " + username + " não encontrado");
        }
        return new UserDetailsData(user);
    }


}
