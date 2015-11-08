package com.logistic.api.model.person.impl;

import com.sun.xml.internal.ws.server.ServerRtException;

/**
 * Created by Oleg on 07.11.2015.
 */
public class FullNameClass implements com.logistic.api.model.person.FullName {
    private String firstName;
    private String lastName;
    private String middleName;

    public FullNameClass(String firstName, String lastName, String middleName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

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
    public String toString() {
        return "FullNameClass{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", middleName='" + middleName + '\'' + '}';
    }
}
