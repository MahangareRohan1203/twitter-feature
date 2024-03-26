#FROM ubuntu:latest
#LABEL authors="mahangare"
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:17
ADD ./twitter-spring-boot.jar twitter-spring-boot.jar
ENTRYPOINT ["java", "-jar", "twitter-spring-boot.jar"]