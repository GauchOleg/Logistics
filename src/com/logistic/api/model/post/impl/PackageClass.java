package com.logistic.api.model.post.impl;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.person.Person;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Oleg on 07.11.2015.
 */
public class PackageClass implements com.logistic.api.model.post.Package{
    private String packageID;
    private int weigth;
    private Type type;
    private Person receiver;
    private Person sender;
    private List<Stamp> stamps;

    public PackageClass (int weigth, Type type, Person receiver, Person sender){
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.weigth = weigth;
        this.packageID = UUID.randomUUID().toString();
        this.stamps = new ArrayList<>();
    }

    @Override
    public String getPackageId() {
        return this.packageID;
    }

    @Override
    public int getWeight() {
        return this.weigth;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Address getReceiverAddress() {
        return this.receiver.getAddress();
    }

    @Override
    public Address getSenderAddress() {
        return this.sender.getAddress();
    }

    @Override
    public FullName getSenderFullName() {
        return this.sender.getFullName();
    }

    @Override
    public FullName getReceiverFullName() {
        return this.receiver.getFullName();
    }

    @Override
    public List<Stamp> getStamps() {
        return this.stamps;
    }

    @Override
    public String toString() {
        return "Package{" + "stamps=" + stamps + ", sender=" + sender + ", receiver=" + receiver + ", type="
                + type + ", weigth=" + weigth + ", packageID='" + packageID + '\'' + '}';
    }
}
