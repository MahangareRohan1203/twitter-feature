package com.dice.twitterfeature.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetResponse {

    private Body body;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Body {
        private TweetResponse.Data data;

    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private User1 user;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User1 {
        private Result result;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private TimeLine2 timeline_v2;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeName {
        private TimeLine2 timeline_v2;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeLine2 {
        private TimeLine timeline;
    }

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeLine {
        private Object instructions;
    }
//    @Data
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    private static class Instructions{
//        private Object
//    }
}
