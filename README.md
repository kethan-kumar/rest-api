# RESTful APIs
Implementation of REST APIs in Spring boot

## Description

An API microservice using spring boot to simulate user registration:
- Exposed REST API to accept a payload of username, password, and IP address.
- Parameter constraints:
  - all parameters must not be blank (!= empty and null)
  - returns error messages if parameter is invalid.
- Password constraints:
  - need to be greater than 8 characters
  - contains at least 1 number
  - contains at least 1 Capitalized letter
  - contains at least 1 special character in this set “_ # $ % .”
  - returns error messages if password is invalid
- Calls the [Geolocation API](https://ip-api.com/docs/api:json) to get geolocation for the provided IP
  - If the IP is not in Canada, returns error message that user is not eligible to register
- When all the validations are passed
  - returns a random uuid
  - welcome message
  - username
  - city name (resolved using ip-geolocation api)
- The API is in OpenAPI specification 3.0.0
- Project uses Maven to build and generated using Spring Initializer

## Technology Stack
- Spring boot 2.6.2
- Maven
- Java 11
- OpenAPI Specifications 3.0.1

## Commands to run the project
- Download the source code from git

      $ git clone https://github.com/kethan-kumar/rest-api.git

- Build the project with all the dependencies using pom.xml

      $ ./mvnw clean install
      
- Build the executable jar for the project

      $ ./mvnw package
      
- Run the jar to test the REST API

      $ java -jar target/rest-service-0.0.1-SNAPSHOT.jar 

## Config
You can update the below from application.properties
- springdoc.api-docs.path=/api-docs
- springdoc.swagger-ui.path=/demo.html 
- api.host.baseurl=http://ip-api.com/json/
- api.host.country=Canada 
- message.welcome=Welcome to Canada
- message.error=User is not eligible to register. Invalid request

Update host country to test user registration rejection according to the IP address.
      
## Test API
- You can test the APIs on http://localhost:8080/demo.html that has inbuilt swagger ui.
- You can also test the APIs in Postman

### Example
- Request URL: http://localhost:8080/signup
- Request Body: 
  * {
    "username": "REST User",
    "password": "Password#123",
    "ipAddress": "24.48.0.1"
    }
- Response:
  * {
    "uuid": "53add723-1f65-4023-9387-082e02c8ff86",
    "username": "REST User",
    "city": "Montreal",
    "message": "Welcome to Canada"
    }
