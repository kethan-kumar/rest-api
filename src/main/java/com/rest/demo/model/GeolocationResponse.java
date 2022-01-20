package com.rest.demo.model;

import lombok.Data;

@Data
public class GeolocationResponse {

    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private  String city;
    private  String zip;
    private  float lat;
    private  float lon;
    private  String timezone;
    private  String isp;
    private  String org;
    private  String as;
    private  String query;
}