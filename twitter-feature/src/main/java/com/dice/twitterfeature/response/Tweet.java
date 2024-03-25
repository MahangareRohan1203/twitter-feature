package com.dice.twitterfeature.response;

import lombok.Data;

@Data
public class Tweet {
    private String description;
    private String image;
    private int retweetCount;
    private int likeCount;
    private String username;
    private String userImage;
}
