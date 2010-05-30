package no.kh.mongo.morphia;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {

    String streetName;
    String postalCode;
    String place;
    String country;


    public void setStreetName(String streetName){
        this.streetName = streetName;    
    }
}
