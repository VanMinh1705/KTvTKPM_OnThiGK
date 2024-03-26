package com.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getListUser(){
        return  userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }
}
