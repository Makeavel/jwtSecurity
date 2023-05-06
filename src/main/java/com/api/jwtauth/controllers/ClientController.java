package com.api.jwtauth.controllers;

import com.api.jwtauth.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @GetMapping
    public List<Client> getAllCongregations() throws Exception {
        return new ArrayList<>();
    }
}
