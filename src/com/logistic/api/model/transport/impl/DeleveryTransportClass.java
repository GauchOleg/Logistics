package com.logistic.api.model.transport.impl;

import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.DeliveryTransport;

/**
 * Created by Oleg on 08.11.2015.
 */
public class DeleveryTransportClass implements DeliveryTransport{
    private Type type;
    private PostOffice startPostOffice;
    private PostOffice destinationPostOffice;

    public DeleveryTransportClass (Type type, PostOffice startPostOffice, PostOffice destinationPostOffice){
        this.type = type;
        this.startPostOffice = startPostOffice;
        this.destinationPostOffice = destinationPostOffice;

    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public PostOffice getStartPostOffice() {
        return this.startPostOffice;
    }

    @Override
    public PostOffice getDestinationPostOffice() {
        return this.destinationPostOffice;
    }
}
