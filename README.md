# RESTful APIs
Implementation of REST APIs in Spring boot

## Description

An API microservice using spring boot to simulate user registration:
- Exposed REST API to accept a payload of username, password, and IP address.
- Parameter contraints:
  - all parameters must not be blank (!= empty and null)
  - returns error messages if parameter is invalid.
- Password contraints:
  - need to be greater than 8 characters
  - contains at least 1 number
  - contains at least 1 Capitalized letter
  - contains at least 1 special character in this set “_ # $ % .”
  - returns error messages if password is invalid
- Calls the [Geolocation API](https://ip-api.com/docs/api:json) to get geolocation for the provided IP
  - If the IP is not in Canada, returns error message that user is not eligible to register
- When all the validations are passed
  - returns a random uuid
  - welcome message
  - username
  - city name (resolved using ip-geolocation api)
- The API is in OpenAPI specification 3.0.0
- Project uses Maven to build and generated using Spring Initializer

## Commands to run the project
- Download the source code from git

      $ git pull https://github.com/kethan-kumar/rest-api.git

- Build the project with all the dependencies using pom.xml

      $ mvn clean install
      
- Build the executable jar for the project

      $ ./mvnw package
      
- Run the jar to test the REST API

      $ java -jar [target folder]/rest-service.jar
      
## Test API
- You can test the APIs on http://localhost:8080/demo.html that has inbuilt swagger ui.
