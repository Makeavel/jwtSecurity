package com.api.jwtsecurity.repository;

import com.api.jwtsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM tb_user u WHERE u.login = ?1", nativeQuery = true)
    public User findUserLogin(String login); // consulta sem npe

    //Set<User> getFindUserLogin(String login) throws Exception;

}
