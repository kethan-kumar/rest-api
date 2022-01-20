package com.rest.demo.controller;

import com.rest.demo.model.ErrorMessage;
import com.rest.demo.model.GeolocationResponse;
import com.rest.demo.model.RegistrationDetails;
import com.rest.demo.model.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@PropertySource("classpath:application.properties")
@Validated
public class RegistrationController {

    RestTemplate restTemplate;
    ErrorMessage errorMessage;
    @Value("${api.host.baseurl}")
    private String externalAPI;
    @Value("${api.host.country}")
    private String country;
    @Value("${message.welcome}")
    private String message;
    @Value("${message.error}")
    private String err;

    @Autowired
    public RegistrationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object register(@Valid @RequestBody RegistrationDetails newUser) {
        RegistrationResponse registrationResponse = null;
        try {
            GeolocationResponse response = restTemplate.postForObject(externalAPI + "{query}", null, GeolocationResponse.class, newUser.getIpAddress());
            if (response != null && response.getCity() != null && response.getCountry().equalsIgnoreCase(country)) {
                registrationResponse = new RegistrationResponse(newUser.getUsername(), response.getCity(), message);
            } else {
                errorMessage = new ErrorMessage();
                errorMessage.setError("403 Forbidden");
                errorMessage.setMessage(err);
                return errorMessage;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return registrationResponse;
    }

}