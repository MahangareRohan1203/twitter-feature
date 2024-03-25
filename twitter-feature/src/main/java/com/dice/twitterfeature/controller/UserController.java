package com.dice.twitterfeature.controller;

import com.dice.twitterfeature.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(@RequestParam String name) throws JsonProcessingException {
        Object userResponse = userService.getUsersByName(name);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/tweets")
    public ResponseEntity<Object> getUserTweetsHandler(@PathVariable String userId) throws JsonProcessingException {
        Object tweetResponse = userService.getTweetsByUserId(userId);
        return new ResponseEntity<>(tweetResponse, HttpStatus.OK);
    }
}