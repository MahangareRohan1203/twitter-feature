package com.dice.twitterfeature.config;

import com.dice.twitterfeature.exception.UserException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GeneralInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientId = request.getHeader("Clientid");
        String clientSecret = request.getHeader("Clientsecret");

//        System.out.println("CLIENT ID: " + clientId);
//        System.out.println("CLIENT SECRET: " + clientSecret);

        if (clientId == null || clientSecret == null) {
            throw new UserException(clientId == null ? "Provide random clientId in Header" : "Provide random clientSecret in Header");
        }
        return true;
    }

}
