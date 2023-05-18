package com.example.newsflash.service;

import com.example.newsflash.model.User;
import com.example.newsflash.model.Username;
import com.example.newsflash.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public List<Username> getUsernames(){
        return userRepository.allUsernames();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }


}
