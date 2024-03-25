package com.dice.twitterfeature.config;

import com.dice.twitterfeature.cacheLayer.LFUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Component
public class AppConfiguration implements WebMvcConfigurer {

    @Autowired
    private GeneralInterceptor generalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalInterceptor);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${twitter.secretKey}")
    private String secretKey;

    @Value("${twitter.host}")
    private String host;

    @Bean
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", secretKey);
        headers.set("X-Rapidapi-Host", host);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @Bean
    public LFUCache cache(){
        return new LFUCache(50);
    }
}
