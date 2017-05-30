
# 1Sky 1Rewards 1Service

The task for this assignment is to create a Reward Service to see which rewards are available based on the channel subscriptions

## Continuous Integration
[![Build Status](https://travis-ci.org/rajeshso/SkyRewardsService.svg?branch=master)](https://travis-ci.org/rajeshso/SkyRewardsService)

Continuous Integration is set up using [Travis CI](https://travis-ci.org).

## Installation
This project only requires JDK 8. Install on linux using this command:

    sudo apt-get install openjdk-8-jdk

### File Permissions
The `gradlew` script should be executable by the user by default. If it is not, run this command:

    chmod u+x gradlew

## Building
The Gradle build system was chosen because with the Gradle Wrapper it is possible to perform a build without any further
installation of third party software. Perform a build with this command:

    ./gradlew build    

## Testing
Unit tests can be run with the `test` gradle task:

    ./gradlew test
    
## Design
The `1Sky1Rewards1Service` is built in SpringBoot. So there is no configuration required to start and use the application.
Just a plain old java command on the Application's main method would bring up the Application.

## Usage
The user can connect using any generic rest services tool. The candidate used postman from chrome.

The url can be http://localhost:8090//rewards
The body of the post statement can be 
```json
{
  "accountid" : 5,	
  "channels" : ["MUSIC", "MOVIES", "SPORTS"]

}
```
The response would be 
```json
{
  "account": 5,
  "rewardValues": [
    "PIRATES OF THE CARIBBEAN COLLECTION",
    "CHAMPIONS LEAGUE FINAL TICKET",
    "KARAOKE PRO MICROPHONE"
  ],
  "success": true,
  "message": "Successful Response for Rewards"
}
```
The Elibiblity Service stub assumes that Account numbers in the range 1 to 5 are customer eligible and numbers in the range 6 to 10 are not eligible for Rewards. There are no other Account numbers known to the system.

## Dependency Injection
The principle of Dependency Injection (DI) is followed throughout the system. DI is done using the simple Spring Boot
    
