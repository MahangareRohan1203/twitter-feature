package com.dice.twitterfeature.apiclient;

import com.dice.twitterfeature.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface TwitterAPIClient {
    public UserResponse getTwitterUsersByName(String name) throws JsonProcessingException;
    public Object getTwitterTweetsByUserId(String id) throws JsonProcessingException;
}
