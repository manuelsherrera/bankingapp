package com.ironhack.demosecurityjwt.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private Integer streetNumber;
    private String cityName;
    private Integer zipCode;

    public Address(String streetName, Integer streetNumber, String cityName, Integer zipCode) {
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setCityName(cityName);
        setZipCode(zipCode);
    }

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
