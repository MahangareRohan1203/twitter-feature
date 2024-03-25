package com.dice.twitterfeature.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private int num_results;
    private List<User> users;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        private long id;
        private String id_str;
        private boolean verified;
        private boolean ext_is_blue_verified;
        private String name;
        private String screen_name;
        private String profile_image_url;
        private String profile_image_url_https;
        private String location;
    }
}
