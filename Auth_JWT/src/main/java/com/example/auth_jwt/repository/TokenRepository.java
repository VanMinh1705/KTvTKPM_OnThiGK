package com.example.auth_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth_jwt.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
