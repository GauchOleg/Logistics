package com.logistic.api.service.impl;

import com.logistic.api.model.Exception.PackageNotFound;
import com.logistic.api.model.Exception.TransitNotFound;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.impl.PackageClass;
import com.logistic.api.model.post.impl.PostOfficeClass;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.model.transport.impl.TransitClass;
import com.logistic.api.service.SenderService;

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
    public List<TransitClass> calculatePossibleTransits(Package parcel) {
        List<TransitClass> result = new ArrayList<>();
        for (TransitClass transitClass : StorageHelper.getTransits()){
            List<PostOffice> transitOffice = transitClass.getTransitOffices();
            int maxWeightLimit = Integer.MAX_VALUE;
            for (PostOffice office: transitOffice){
                if (maxWeightLimit > office.getMaxWeight()){
                    maxWeightLimit = office.getMaxWeight();
                }
            }

        }
        return result;
    }

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        if (parcel == null) throw new PackageNotFound();
        if (transit == null) throw new TransitNotFound();
        return false;
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        PackageClass parcel = StorageHelper.getPackage(id);
        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        PostOfficeClass currentOffice = (PostOfficeClass) getPackageCurrentPosition(id);
        PackageClass parcel = StorageHelper.getPackage(id);
        if (currentOffice.getAddress().equals(parcel.getReceiverAddress())){
            return 0;
        }
        TransitClass transit = StorageHelper.getTransits(id);
        boolean isOnTheWay = false;
        int miles = 0;
        PostOfficeClass previoseOffice = null;
        for (PostOffice office : transit.getTransitOffices()){
            if (isOnTheWay){
                miles+=office.getGeolocation().distance(previoseOffice.getGeolocation());
            }
            if(currentOffice.getAddress().equals(office.getAddress())){
                isOnTheWay = true;
            }
            previoseOffice = (PostOfficeClass) office;
        }
            return miles;
    }
}
