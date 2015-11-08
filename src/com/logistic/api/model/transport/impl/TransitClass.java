package com.logistic.api.model.transport.impl;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.Transit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Oleg on 08.11.2015.
 */
public class TransitClass implements Transit {
    private List<PostOffice> Office;
    private double price;

    public TransitClass (List<PostOffice> Office, double price){
        this.Office = Collections.unmodifiableList(new ArrayList(Office));
        this.price = price;
    }

    @Override
    public List<PostOffice> getTransitOffices() {
        return this.Office;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
