package com.api.jwtsecurity.controller;

import com.api.jwtsecurity.model.Role;
import com.api.jwtsecurity.model.User;
import com.api.jwtsecurity.repository.RoleRepository;
import com.api.jwtsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final RoleRepository repository;

    public UserController(UserService userService , RoleRepository repository){

        this.userService = userService;
        this.repository = repository;
    }

    @PreAuthorize("hasRole('dev')")
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

    @PostMapping("/role")
    public Role createrole(@RequestBody Role role){
        return repository.save(role);
    }

    @GetMapping("/readAllRoles")
    public List<Role> readAllRoles(){
        return repository.findAll();
    }

}
