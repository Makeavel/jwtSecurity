package com.api.jwtauth.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(){
        super("Senha inválida!");
    }
}
