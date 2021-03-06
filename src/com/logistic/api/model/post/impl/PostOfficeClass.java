package com.logistic.api.model.post.impl;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.post.Stamp;
import com.logistic.impl.model.post.*;

import java.awt.*;


public abstract class PostOfficeClass implements PostOffice {


        @Override
        public Stamp getStamp() {
            return this.;
        }

        @Override
        public Address getAddress() {
            return this.;
        }

        @Override
        public Package.Type getAcceptableTypes() {
            return this.;
        }

        @Override
        public int getMaxWeight() {
            return this.;
        }

        @Override
        public boolean sendPackage(Package parcel) {
            return false;
        }

        @Override
        public boolean receivePackage(Package parcel) {
            return false;
        }

        @Override
        public int getCode() {
            return this.getCode();
        }

        @Override
        public Point getGeolocation() {
            return this.getGeolocation();
        }

    }
