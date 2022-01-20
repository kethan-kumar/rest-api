package com.rest.demo.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegistrationDetails {

    @NotBlank(message = "Username cannot be empty! (json key: username)")
    @Size(min = 3, message = "Username should be at least 3 characters in length")
    private String username;

    @NotBlank(message = "Password cannot be empty! (json key: password)")
    @Size(min = 9, message = "Password should be greater than 8 characters in length")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[_#$%.]).{8,}$",
            message = "Password must contain at least 1 number, 1 Capitalized letter, 1 special character from {_#$%.}")
    private String password;

    @NotBlank(message = "IP Address cannot be empty! (json key: ipAddress)")
    @Pattern(regexp = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
            message = "Invalid IP address format")
    private String ipAddress;
}