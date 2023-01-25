package com.api.jwtsecurity.repository;

import com.api.jwtsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {

    //@Query(value = "SELECT * FROM users u WHERE u.login = ?1", nativeQuery = true)
    User findUserByLogin(String login); // consulta sem npe


    //Set<User> getFindUserLogin(String login) throws Exception;

}
