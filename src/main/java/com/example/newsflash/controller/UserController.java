package com.example.newsflash.controller;

import com.example.newsflash.model.User;
import com.example.newsflash.model.Username;
import com.example.newsflash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id){
        Optional user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all-username")
    public ResponseEntity<List<Username>> getAllUsername(){
        List<Username> usernameList = userService.getUsernames();
        return new ResponseEntity<>(usernameList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
