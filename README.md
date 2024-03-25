# Twitter-Feature

## Introduction
Building twitter features using Rapid-API 

## Project Type
Fullstack

## Deplolyed App
Frontend: https://deployed-site.whatever
Backend: https://deployed-site.whatever

## Video Walkthrough of the project



## Video Walkthrough of the codebase

## Features
- Search users by name
- Retrieve all tweets of user

## design decisions or assumptions


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

API Endpoints

Database Configuration
Configure your database settings in application.properties:


## Usage

Include screenshots as necessary.

## Credentials
- Add random clientId and clientSecret in Header while calling rest api endpoints.

## APIs Used
https://rapidapi.com/Glavier/api/twitter135

## API Endpoints Created

GET /users?name={elonmusk} - retrieve all users with name elonmusk

GET /users/{userId}/tweets - retrieve all the tweets of a user


## Technology Stack
- Java
- Spring Boot
- React.js
- RapidAPI
