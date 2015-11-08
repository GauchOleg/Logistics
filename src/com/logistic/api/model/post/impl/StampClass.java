package com.logistic.api.model.post.impl;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.Stamp;

import java.util.Date;

/**
 * Created by Oleg on 08.11.2015.
 */
public class StampClass implements Stamp {
    private Address postOfficeAddres;
    private Date stampDate;

    public StampClass (Address address, Date date){
        this.postOfficeAddres = address;
        this.stampDate = date;
    }

    @Override
    public Address getPostOfficeAddress() {
        return this.postOfficeAddres;
    }

    @Override
    public Date getStampDate() {
        return this.stampDate;
    }
}
