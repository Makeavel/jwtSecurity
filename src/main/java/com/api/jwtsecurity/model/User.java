package com.api.jwtsecurity.model;

import com.api.jwtsecurity.security.JWTFilterAuthentication;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String login;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pc = "panqueca com caramelo";
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    ;

}
