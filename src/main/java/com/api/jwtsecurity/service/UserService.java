package com.api.jwtsecurity.service;

import com.api.jwtsecurity.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(User user);

    ResponseEntity<Boolean> findByLogin(String login, String password) throws Exception;
}
