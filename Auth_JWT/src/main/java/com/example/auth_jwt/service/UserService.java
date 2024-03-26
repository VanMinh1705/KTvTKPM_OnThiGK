package com.example.auth_jwt.service;

import com.example.auth_jwt.authen.UserPrincipal;
import com.example.auth_jwt.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
