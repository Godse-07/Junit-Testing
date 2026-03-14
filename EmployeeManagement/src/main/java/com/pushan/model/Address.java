package com.pushan.model;

public class Address {

    private int id;
    private String city;
    private String state;
    private String country;
    private int pincode;

    public Address() {
    }

    public Address(int id, String city, String state, String country, int pincode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPincode() {
        return pincode;
    }
}