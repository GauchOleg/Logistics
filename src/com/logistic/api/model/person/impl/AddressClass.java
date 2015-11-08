package com.logistic.api.model.person.impl;

/**
 * Created by Oleg on 07.11.2015.
 */
public class AddressClass implements com.logistic.api.model.person.Address{
    private String street;
    private String city;
    private String country;
    private int code;

    public AddressClass(String street, String city, String country, int code) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.code = code;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "AddressClass{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", country='" + country + '\'' + ", code=" + code + '}';
    }
}
