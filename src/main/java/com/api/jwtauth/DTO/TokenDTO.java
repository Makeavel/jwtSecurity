package com.api.jwtauth.DTO;
import com.api.jwtauth.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private User userDetails;
    //private String login;
    private String token;
}
