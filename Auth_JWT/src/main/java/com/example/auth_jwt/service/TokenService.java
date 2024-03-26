package com.example.auth_jwt.service;

import com.example.auth_jwt.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);

}
