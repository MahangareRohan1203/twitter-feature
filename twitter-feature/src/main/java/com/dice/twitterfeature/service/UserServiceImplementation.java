package com.dice.twitterfeature.service;

import com.dice.twitterfeature.apiclient.TwitterAPIClient;
import com.dice.twitterfeature.cacheLayer.LFUCache;
import com.dice.twitterfeature.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {

    @Autowired
    private TwitterAPIClient twitterAPIClient;

    @Autowired
    private LFUCache cache;

    @Override
    public UserResponse getUsersByName(String name) throws JsonProcessingException {
        Object existCache = cache.get(name);
        if (existCache != null) {
            log.info("Cache username ");
            return (UserResponse) existCache;
        }
        UserResponse response = twitterAPIClient.getTwitterUsersByName(name);
        cache.put(name, response);
        return response;
    }

    @Override
    public Object getTweetsByUserId(String userId) throws JsonProcessingException {
        Object existCache = cache.get(userId);
        if (existCache != null) {
            log.info("Cache used of userId");
            return existCache;
        }
        Object response = twitterAPIClient.getTwitterTweetsByUserId(userId);
        cache.put(userId, response);
        return response;
    }
}
