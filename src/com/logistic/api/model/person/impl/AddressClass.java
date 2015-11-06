package com.logistic.api.model.person.impl;

import com.logistic.api.model.person.Address;


public class AddressClass implements Address {
    private String street;
    private String country;
    private String city;
    private int code;

    public AddressClass(String street, String country, String city, int code) {
        this.street = street;
        this.country = country;
        this.city = city;
        this.code = code;

    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public String getCity() { return this.city;}

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "[" + street + " " + country + " " + city + "]";
    }
}
