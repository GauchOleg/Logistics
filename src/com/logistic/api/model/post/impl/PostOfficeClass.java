package com.logistic.api.model.post.impl;
import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.post.Stamp;

import java.awt.*;
import java.util.Date;


/**
 * Created by Oleg on 07.11.2015.
 */
public class PostOfficeClass implements PostOffice {
    private Address address;
    private Package.Type aceptebleType;
    private Point coordinates;
    private int maxWeight;

    public PostOfficeClass (Address address, Package.Type aceptebleType, Point coordinates, int maxWeight){
        this.address = address;
        this.aceptebleType = aceptebleType;
        this.coordinates = coordinates;
        this.maxWeight = maxWeight;
    }

    @Override
    public Stamp getStamp() {
        return new StampClass(this.address,new Date());
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Package.Type getAcceptableTypes() {
        return this.aceptebleType;
    }

    @Override
    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public boolean sendPackage(Package parcel) throws Exception {
        return (!parcel.getReceiverAddress().equals(address));
    }

    @Override
    public boolean receivePackage(Package parcel) {
        parcel.getStamps().add(getStamp());
        return true;
    }

    @Override
    public int getCode() {
        return this.address.getCode();
    }

    @Override
    public Point getGeolocation() {
        return this.getGeolocation();
    }

    @Override
    public String toString() {
        return "PostOffice{" + "address=" + address + ", aceptebleType=" + aceptebleType + ", coordinates=" +
                coordinates + ", maxWeight=" + maxWeight + '}';
    }
}
