package com.logistic.api.model.person.impl;

/**
 * Created by Oleg on 07.11.2015.
 */
public class PersonClass implements com.logistic.api.model.person.Person {
    private AddressClass address;
    private FullNameClass fullName;

    public PersonClass(AddressClass address, FullNameClass fullName){
        this.address = address;
        this.fullName = fullName;
    }

    @Override
    public com.logistic.api.model.person.Address getAddress() {
        return this.address;
    }

    @Override
    public com.logistic.api.model.person.FullName getFullName() {
        return this.fullName;
    }
}
