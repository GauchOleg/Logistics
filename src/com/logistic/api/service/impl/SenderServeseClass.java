package com.logistic.api.service.impl;

import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.impl.PostOfficeClass;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.model.transport.impl.TransitClass;
import com.logistic.api.service.SenderService;
import com.logistic.api.service.impl.StorageHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Oleg on 08.11.2015.
 */
public class SenderServeseClass implements SenderService {

    private static final int LOST_THRESHOLD = 80;
    private static final int MAX_LOST_THRESHOLD = 100;

    @Override
    public List<PostOffice> getAllOffices() {
        return StorageHelper.getAllOffices();

    }

        private TransitClass reveresTransite (Transit transit){
        List<PostOfficeClass> reversOffice = new ArrayList(transit.getTransitOffices());
        Collections.reverse(reversOffice);
        TransitClass result = new TransitClass(reversOffice,transit.getPrice());
        return result;
    }


    @Override
    public List<Transit> calculatePossibleTransits(com.logistic.api.model.post.Package parcel) {
        return null;
    }

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        return false;
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        return 0;
    }
}
