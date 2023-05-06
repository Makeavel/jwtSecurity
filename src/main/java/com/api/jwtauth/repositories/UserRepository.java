package com.api.jwtauth.repositories;

import com.api.jwtauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByLogin(String login);
}
