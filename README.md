# Twitter-Feature

## Introduction

Building twitter features using Rapid-API

## Project Type

Fullstack

## Deplolyed App

Frontend: https://twitter-rest-api.netlify.app/

Backend: https://twitter-feature-production.up.railway.app/

Note: There can be chance that my rapid-api limit exceeds in such case you will not able to fetch data. 


## Video Walkthrough of the project

[Video Presentation](https://drive.google.com/file/d/1nx8ss4NPe70536TM9g2haqCuT7Q7rRse/view?usp=sharing)

## Video Walkthrough of the codebase

[Code Overview](https://drive.google.com/file/d/1M8SdIFilSlCStuXvmKw20FW6sYsJgaNa/view?usp=drive_link)

## Features

- Search users by name
- Retrieve all tweets of user

## design decisions or assumptions
For small scale I have used monolithic application

## Installation & Getting started

To get started, follow these steps:

Clone the project using git command:

```bash
git clone https://github.com/MahangareRohan1203/twitter-feature.git
```

Configure the rapid-api's secret key in application.properties inside /src/main/java/resources/application.properties.

```
spring.application.name=twitter-feature
server.port=8080

twitter.baseURL = https://twitter135.p.rapidapi.com

twitter.secretKey = loremalphabeta

twitter.host = twitter135.p.rapidapi.com
```

Build and run the application.

## Credentials

- Add random clientId and clientSecret in Header while calling rest api endpoints.

## Third Party APIs Used

https://rapidapi.com/Glavier/api/twitter135

For Finding Users : https://twitter135.p.rapidapi.com/AutoComplete/

For Users Tweet : https://twitter135.p.rapidapi.com/v2/UserTweets/

## API Endpoints Created

GET /users?name={elonmusk} - retrieve all users with name elonmusk

GET /users/{userId}/tweets - retrieve all the tweets of a user

## Technology Stack

- Java
- Spring Boot
- React.js
- RapidAPI

## [Frontend Repository Link ](https://github.com/MahangareRohan1203/twitter-frontend)
