package com.logistic.api.model.post.impl;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.person.Person;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class PackageClass implements Package {
    private String id;
    private int weight;
    private Type type;
    private Person reciever;
    private Person sender;
    private List<Stamp> stamps;


    public PackageClass(int weight, Type type, Person reciever, Person sender) {
        this.id = UUID.randomUUID().toString();
        this.weight = weight;
        this.type = type;
        this.reciever = reciever;
        this.sender = sender;
        this.stamps = new ArrayList<>();

    }


        @Override
        public String getPackageId () {
            return this.id;
        }

        @Override
        public int getWeight () {
            return this.weight;
        }

        @Override
        public Type getType () {
            return this.type;
        }

        @Override
        public Address getReceiverAddress () {
            return this.reciever.getAddress();
        }

        @Override
        public Address getSenderAddress () {
            return this.sender.getAddress();
        }

        @Override
        public FullName getSenderFullName() {
            return this.sender.getFullName();
        }

        @Override
        public FullName getReceiverFullName () {
            return this.reciever.getFullName();
        }

        @Override
        public List<Stamp> getStamps () {
            return this.stamps;
        }

    @Override
    public String toString() {    // make this part logic!!!
        return "PackageClass{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", type=" + type +
                ", reciever=" + reciever +
                ", sender=" + sender +
                ", stamps=" + stamps +
                '}';
    }
}
