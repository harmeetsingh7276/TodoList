package com.harmeet.springboot.TodoList.login.controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("harmeet");
        boolean isValidPassword = password.equalsIgnoreCase("harmeet");
        return isValidPassword && isValidUsername;
    }
}
