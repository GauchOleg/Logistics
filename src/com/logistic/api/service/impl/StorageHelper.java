package com.logistic.api.service.impl;
import com.logistic.api.model.person.impl.AddressClass;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.post.impl.PackageClass;
import com.logistic.api.model.post.impl.PostOfficeClass;
import com.logistic.api.model.transport.DeliveryTransport;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.model.transport.impl.DeleveryTransportClass;
import com.logistic.api.model.transport.impl.TransitClass;
import com.logistic.api.service.Storage;
import com.sun.xml.internal.ws.server.ServerRtException;


import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Acer on 06.11.2015.
 */
public class StorageHelper {
    public static final String TRANSIT = "transit";
    public static final String POST_OFFICE = "postOffice";
    public static final String ADDRESSES = "addresses";
    public static final String DELIVERY_TRANSPORT = "deliveryTransport";
    public static final String AVAILABLE_TRANSIT = "availableTransit";


    public static void initializeDate() {
        Random random = new Random();
        Storage.getInstance().putToStorage(ADDRESSES, Arrays.asList(
                new AddressClass("Lenina", "Kiev", "Ukraine", 10001),
                new AddressClass("Lomonosova", "Dnepr", "Ukraine", 11002),
                new AddressClass("Karla Marksa", "Kharkov", "Ukrane", 12003),
                new AddressClass("Wictori Aveny", "Kherson", "Ukraine", 13004),
                new AddressClass("Naberegnaya", "Doneck", "Russia", 20001),
                new AddressClass("Vinogradova", "Semferopol", "Russia", 21002),
                new AddressClass("Cvetochnaya", "Moskva", "Russia", 22003),
                new AddressClass("Abricosova", "Gitomir", "Ukraine", 13005),
                new AddressClass("Invalid Street", "Invalid City", "Invalid Country", 00000)

        ));
        Storage.getInstance().putToStorage(POST_OFFICE, Arrays.asList(
                new PostOfficeClass(new AddressClass("Lenina 1", "Kiev", "Ukraine", 10001), Package.Type.T_25, new Point(1, 1), 25),
                new PostOfficeClass(new AddressClass("Lomonosova 1", "Dnepr", "Ukraine", 11002), Package.Type.T_27, new Point(2, 2), 50),
                new PostOfficeClass(new AddressClass("Karla Marksa 1", "Kharkov", "Ukrane", 12003), Package.Type.T_30, new Point(3, 3), 100),
                new PostOfficeClass(new AddressClass("Wictori Aveny 1", "Kherson", "Ukraine", 13004), Package.Type.T_CP, new Point(4, 4), 5),
                new PostOfficeClass(new AddressClass("Naberegnaya 1", "Doneck", "Russia", 20001), Package.Type.T_10, new Point(5, 5),10),
                new PostOfficeClass(new AddressClass("Vinogradova 1", "Semferopol", "Russia", 21002), Package.Type.T_30, new Point(6, 6), 100),
                new PostOfficeClass(new AddressClass("Cvetochnaya 1", "Moskva", "Russia", 22003), Package.Type.T_30, new Point(7, 7), 100),
                new PostOfficeClass(new AddressClass("Abricosova", "Gitomir", "Ukraine", 13005), Package.Type.T_CP, new Point(8, 8), 5)

        ));

        Storage.getInstance().putToStorage(DELIVERY_TRANSPORT, Arrays.asList(
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(10001),getPostCode(11002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(11002),getPostCode(21002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(12003),getPostCode(20001)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(13004),getPostCode(10001)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(12003),getPostCode(13004)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(21002),getPostCode(11002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(22003),getPostCode(11002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(13005),getPostCode(13004)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(21002),getPostCode(13004)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(22003),getPostCode(12003)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(12003),getPostCode(11002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(21002),getPostCode(11002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(10001),getPostCode(12003)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(12003),getPostCode(21002)),
                new DeleveryTransportClass(DeliveryTransport.Type.LAND,getPostCode(21002),getPostCode(13004))
        ));
// way from Kiev/Dnepr
        Storage.getInstance().putToStorage(AVAILABLE_TRANSIT,(Arrays.asList(
            new TransitClass(Arrays.asList
                    (getPostCode(10001), getPostCode(11002)),random.nextInt(100)+20),
            new TransitClass(Arrays.asList
                    (getPostCode(10001), getPostCode(21002),getPostCode(11002)),random.nextInt(100)+20),
            new TransitClass(Arrays.asList
                    (getPostCode(10001),getPostCode(20001),getPostCode(11002),getPostCode(11002)),random.nextInt(100)+20),
            new TransitClass(Arrays.asList
                    (getPostCode(10001),getPostCode(13004),getPostCode(12003),getPostCode(22003),getPostCode(11002)),random.nextInt(100)+20),

// way from Kiev/Kharkov
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(22003),getPostCode(12003)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(13005),getPostCode(20001),getPostCode(12003)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(11002),getPostCode(12003),getPostCode(13004),getPostCode(12003)),random.nextInt(100)+20),new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(12003)),random.nextInt(100)+20),

// way from Kiev/Kherson
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(22003),getPostCode(13004)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(22003),getPostCode(20001),getPostCode(13004)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(12003),getPostCode(22003),getPostCode(10001),getPostCode(13004)),random.nextInt(100)+20),

// way from Kiev/Doneck
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(20001)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(22003),getPostCode(20001)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(13005),getPostCode(20001),getPostCode(20001)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(11002),getPostCode(12003),getPostCode(13004),getPostCode(20001)),random.nextInt(100)+20),


// way from Kiev/Semferopol
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(12003),getPostCode(20001),getPostCode(21002)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(13005),getPostCode(22003),getPostCode(12003),getPostCode(21002)),random.nextInt(100)+20),


// way from Kiev/Moskva
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(22003)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(13004),getPostCode(22003)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(21001),getPostCode(20001),getPostCode(22003)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(13005),getPostCode(11002),getPostCode(20001),getPostCode(22003)),random.nextInt(100)+20),



//way from Kiev/Gitomir
              new TransitClass(Arrays.asList
                      (getPostCode(10001), getPostCode(13005)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(10001),getPostCode(11002),getPostCode(20001),getPostCode(13004),getPostCode(13005)),random.nextInt(100)+20),



//way from Dnepr/Kiev
              new TransitClass(Arrays.asList
                      (getPostCode(11002), getPostCode(10001)),random.nextInt(100)+20),
              new TransitClass(Arrays.asList
                      (getPostCode(11002),getPostCode(12003),getPostCode(20001),getPostCode(13004),getPostCode(10001)),random.nextInt(100)+20),


//way from Dnepr/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(13005),getPostCode(21002),getPostCode(22003),getPostCode(12003)),random.nextInt(100)+20),


//way from Dnepr/Kherson
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(22003),getPostCode(12003),getPostCode(10001),getPostCode(13004)),random.nextInt(100)+20),

//way from Dnepr/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(21002),getPostCode(12003),getPostCode(13005),getPostCode(20001)),random.nextInt(100)+20),

//way from Dnepr/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(13004),getPostCode(10001),getPostCode(22003),getPostCode(21002)),random.nextInt(100)+20),

//way from Dnepr/Moskvs
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(10001),getPostCode(21002),getPostCode(13003),getPostCode(22003)),random.nextInt(100)+20),

//way from Dnepr/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(11002), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(11002),getPostCode(10001),getPostCode(12003),getPostCode(13004),getPostCode(13005)),random.nextInt(100)+20),

//way from Kharkov/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(11002),getPostCode(22003),getPostCode(13004),getPostCode(10001)),random.nextInt(100)+20),


//way from Kharkov/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(13005),getPostCode(22003),getPostCode(13004),getPostCode(11002)),random.nextInt(100)+20),


//way from Kharkov/Kherson
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(11002),getPostCode(10001),getPostCode(20001),getPostCode(13004)),random.nextInt(100)+20),


//way from Kharkov/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(11002),getPostCode(21002),getPostCode(13004),getPostCode(20001)),random.nextInt(100)+20),


//way from Kharkov/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(11002),getPostCode(22003),getPostCode(13005),getPostCode(21002)),random.nextInt(100)+20),


//way from Kharkov/Moskva
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(11002),getPostCode(13004),getPostCode(10001),getPostCode(22003)),random.nextInt(100)+20),


//way from Kharkov/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(12003), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(12003),getPostCode(22003),getPostCode(11002),getPostCode(13004),getPostCode(13005)),random.nextInt(100)+20),


//way from Kherson/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(11002),getPostCode(12003),getPostCode(22003),getPostCode(10001)),random.nextInt(100)+20),


//way from Kherson/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(20001),getPostCode(12003),getPostCode(13005),getPostCode(11002)),random.nextInt(100)+20),


//way from Kherson/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(13005),getPostCode(22002),getPostCode(11002),getPostCode(12003)),random.nextInt(100)+20),


//way from Kherson/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(22003),getPostCode(12003),getPostCode(11002),getPostCode(20001)),random.nextInt(100)+20),


//way from Kherson/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(23003),getPostCode(12003),getPostCode(10001),getPostCode(21002)),random.nextInt(100)+20),


//way from Kherson/Moskva
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(11002),getPostCode(10001),getPostCode(13005),getPostCode(22003)),random.nextInt(100)+20),


//way from Kherson/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(13004), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13004),getPostCode(22003),getPostCode(10001),getPostCode(20001),getPostCode(13005)),random.nextInt(100)+20),


//way from Doneck/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(11002),getPostCode(22003),getPostCode(13004),getPostCode(10001)),random.nextInt(100)+20),


//way from Doneck/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(13005),getPostCode(22003),getPostCode(21002),getPostCode(11002)),random.nextInt(100)+20),


//way from Doneck/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(22003),getPostCode(13005),getPostCode(13004),getPostCode(12003)),random.nextInt(100)+20),


//way from Doneck/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(11002),getPostCode(10001),getPostCode(22003),getPostCode(21002)),random.nextInt(100)+20),


//way from Doneck/Moskva
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(13005),getPostCode(12003),getPostCode(11002),getPostCode(22003)),random.nextInt(100)+20),


//way from Doneck/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(20001), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(20001),getPostCode(10001),getPostCode(22003),getPostCode(13004),getPostCode(13005)),random.nextInt(100)+20),



//way from Semferopol/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(11002),getPostCode(22003),getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(10001),getPostCode(13005),getPostCode(13004),getPostCode(10001)),random.nextInt(100)+20),


//way from Semferopol/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(13005),getPostCode(10001),getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(22003),getPostCode(12003),getPostCode(13005),getPostCode(11002)),random.nextInt(100)+20),


//way from Semferopol/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(10001),getPostCode(20001),getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(13005),getPostCode(22003),getPostCode(13004),getPostCode(12003)),random.nextInt(100)+20),


//way from Semferopol/Kherson
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(13005),getPostCode(20001),getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(20001),getPostCode(12003),getPostCode(22003),getPostCode(13004)),random.nextInt(100)+20),


//way from Semferopol/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(10001),getPostCode(13005),getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(11002),getPostCode(12003),getPostCode(13004),getPostCode(20001)),random.nextInt(100)+20),


//way from Semferopol/Moskva
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(13005),getPostCode(20001),getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(10001),getPostCode(12003),getPostCode(13004),getPostCode(22003)),random.nextInt(100)+20),


//way from Semferopol/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(21002), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(20001),getPostCode(11002),getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(21002),getPostCode(11002),getPostCode(22003),getPostCode(13004),getPostCode(13005)),random.nextInt(100)+20),


//way from Moskva/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(21002),getPostCode(20001),getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(11002),getPostCode(12003),getPostCode(13004),getPostCode(10001)),random.nextInt(100)+20),


//way from Moskva/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(21002),getPostCode(20001),getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(12003),getPostCode(13005),getPostCode(11002)),random.nextInt(100)+20),


//way from Moskva/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(13005),getPostCode(20001),getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(22003),getPostCode(13004),getPostCode(12003)),random.nextInt(100)+20),


//way from Moskva/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(21002),getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(11002),getPostCode(12003),getPostCode(13004),getPostCode(20001)),random.nextInt(100)+20),


//way from Moskva/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(13005),getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(20001),getPostCode(12003),getPostCode(13004),getPostCode(21002)),random.nextInt(100)+20),


//way from Moskva/Gitomir
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(22003),getPostCode(13005)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(11002),getPostCode(11002),getPostCode(22003),getPostCode(13005)),random.nextInt(100)+20),


//way from Moskva/Kherson
                new TransitClass(Arrays.asList
                        (getPostCode(22003), getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(11002),getPostCode(20001),getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(22003),getPostCode(10001),getPostCode(12003),getPostCode(13005),getPostCode(13004)),random.nextInt(100)+20),


//way from Gitomir/Kiev
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(22003),getPostCode(20001),getPostCode(10001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(12003),getPostCode(13005),getPostCode(10001)),random.nextInt(100)+20),



//way from Gitomir/Dnepr
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(10001),getPostCode(20001),getPostCode(11002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(10001),getPostCode(12003),getPostCode(22003),getPostCode(11002)),random.nextInt(100)+20),


//way from Gitomir/Kharkov
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(22003),getPostCode(20001),getPostCode(12003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(22003),getPostCode(13004),getPostCode(12003)),random.nextInt(100)+20),


//way from Gitomir/Kherson
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(10001),getPostCode(21002),getPostCode(13004)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(22003),getPostCode(10001),getPostCode(11002),getPostCode(13004)),random.nextInt(100)+20),


//way from Gitomir/Doneck
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(22003),getPostCode(10001),getPostCode(20001)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(12003),getPostCode(10001),getPostCode(20001)),random.nextInt(100)+20),


//way from Gitomir/Semferopol
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(23001),getPostCode(20001),getPostCode(21002)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(10001),getPostCode(13004),getPostCode(21002)),random.nextInt(100)+20),


//way from Gitomir/Moskva
                new TransitClass(Arrays.asList
                        (getPostCode(13005), getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(13004),getPostCode(22003)),random.nextInt(100)+20),
                new TransitClass(Arrays.asList
                        (getPostCode(13005),getPostCode(11002),getPostCode(21003),getPostCode(13004),getPostCode(22003)),random.nextInt(100)+20)
        )));
    }

    public static PostOfficeClass getPostCode(int code) {
        List<PostOfficeClass> offices = Storage.getInstance().<List>getById(POST_OFFICE);
        for (PostOfficeClass postOffice : offices) {
            if (postOffice.getAddress().getCode() == code) {
                return postOffice;
            }
        }
        return null;
    }

    public static List getAllOffices(){
        return Storage.getInstance().<List>getById(POST_OFFICE);
    }

    public static List<TransitClass> getTransits (){
        return Storage.getInstance().<List>getById(AVAILABLE_TRANSIT);
    }

    public static PackageClass getPackage (String id){
        return Storage.getInstance().<PackageClass>getById(id);
    }
    public static TransitClass getTransits (String id){
        return Storage.getInstance().<TransitClass>getById(id + TRANSIT);
    }

    public static AddressClass getRandomAddress (){
        Random random = new Random();
        List<AddressClass> address = Storage.getInstance().<List>getById(ADDRESSES);
        return address.get(random.nextInt(address.size()));
    }
}
