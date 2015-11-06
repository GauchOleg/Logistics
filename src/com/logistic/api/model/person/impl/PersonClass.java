package com.logistic.api.model.person.impl;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class PersonClass implements Person, FullName {
    private Address address;
    private String firstName;
    private String lastName;
    private String middleName;


//    public PersonClass() {
//        super();
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getMiddleName() {
        return this.middleName;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public FullName getFullName() {
        return this;
    }

    @Override
    public String toString() {
        return "Person [" + firstName + " " + lastName + " " + middleName + "]" + address;
    }


    public PersonClass (String firstName, )
}


