package com.api.jwtsecurity.controller;

import com.api.jwtsecurity.model.User;
import com.api.jwtsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/readAllUsers")
    public List<User> readAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/createUser")
    public User createUsers(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/validateUser")
    public ResponseEntity<Boolean> validPassword(@RequestParam String login , @RequestParam String password) throws Exception {
        return userService.findByLogin(login, password);
    }

}
