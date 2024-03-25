package com.dice.twitterfeature.apiclient;

import com.dice.twitterfeature.response.FetchResponse;
import com.dice.twitterfeature.response.TweetResponse;
import com.dice.twitterfeature.response.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class TwitterAPIClientImplementation implements TwitterAPIClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${twitter.baseURL}")
    public String baseURI;

    @Autowired
    private HttpHeaders headers;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public UserResponse getTwitterUsersByName(String name) throws JsonProcessingException {
        try {
            String uri = baseURI + "/AutoComplete/?q=" + name;
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<Object> json = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);

            if (json.getStatusCode() == HttpStatus.OK) {
                System.out.println(json);
                String json1 = mapper.writeValueAsString(json);
                FetchResponse userResponse = mapper.readValue(json1, FetchResponse.class);
                return userResponse.getBody();
            } else {
                log.info("Json Response :{}", json);
                throw new RuntimeException("Failed to fetch data from another server");
            }

        } catch (JsonProcessingException jsonProcessingException) {
            log.warn("JSON Processing Exception :{}", jsonProcessingException.getMessage());
            throw new RuntimeException("Internal Server error in parsing");
        } catch (Exception exception) {
            log.warn("Exception :{}", exception.getMessage());
            throw new RuntimeException("Internal Server Error");
        }
    }

    @Override
    public Object getTwitterTweetsByUserId(String userId) throws JsonProcessingException {
        try {
            String uri = baseURI + "/v2/UserTweets/?id=" + userId + "&count=40";
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<Object> json = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);
            if (json.getStatusCode() == HttpStatus.OK) {

                String json1 = mapper.writeValueAsString(json);
//                return parseJsonResponse(json1);
                TweetResponse tweetResponse = mapper.readValue(json1, TweetResponse.class);
                return tweetResponse.getBody().getData().getUser().getResult().getTimeline_v2().getTimeline().getInstructions();
            } else {
                log.info("Json Response :{}", json);
                throw new RuntimeException("Failed to fetch data from another server");
            }
        } catch (JsonProcessingException jsonProcessingException) {
            log.warn("JSON Processing Exception :{}", jsonProcessingException.getMessage());
            throw new RuntimeException("Internal Server error in parsing");
        } catch (Exception exception) {
            log.warn("Exception :{}", exception.getMessage());
            throw new RuntimeException("Internal Server Error");
        }
    }


}
