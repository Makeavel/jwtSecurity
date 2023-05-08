package com.api.jwtauth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(unique = true)
    @NotEmpty(message = "{field.login.required}")
    private String login;

    @Column
    @NotEmpty(message = "{field.password.required}")
    private String password;

    private boolean admin;

    @Column(name = "email" , unique = true)
    @NotEmpty(message = "{field.email.required}")
    private String email;

    @Column(name = "endereco")
    @NotEmpty(message = "{field.cep.required}")
    private String cep;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @ElementCollection
    private List<String> intoleranciaAlimentar;

    @ElementCollection
    private  List<String> restricaoAlimentar;
}
