package no.kh.mongo.morphia;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address {

  private String streetName;
  private String postalCode;
  private String place;
  private String country;

  public Address() {
  }

  public Address(String streetName, String postalCode, String place, String country) {
    this.streetName = streetName;
    this.postalCode = postalCode;
    this.place = place;
    this.country = country;
  }


}
