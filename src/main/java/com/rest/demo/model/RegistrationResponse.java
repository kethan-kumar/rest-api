package com.rest.demo.model;

import lombok.Data;

import java.util.UUID;

public @Data class RegistrationResponse {

    private UUID uuid = UUID.randomUUID();
    private final String username;
    private final String city;
    private final String message;

}
