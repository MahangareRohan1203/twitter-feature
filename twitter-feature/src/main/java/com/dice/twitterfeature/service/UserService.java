package com.dice.twitterfeature.service;

import com.dice.twitterfeature.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {

    public UserResponse getUsersByName(String name) throws JsonProcessingException;

    public Object getTweetsByUserId(String id) throws JsonProcessingException;
}
