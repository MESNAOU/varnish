package com.microservice.metier_microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Unit1 {
    @JsonProperty("unit1ID")
    private int unit1ID;

    @JsonProperty("att1")
    private int att1;
    @JsonProperty("att2")
    private String att2;
    @JsonProperty("att3")
    private int att3;
    @JsonProperty("att4")
    private String att4;
    @JsonProperty("att5")
    private int att5;

}