package no.kh.mongo.direct;

import com.mongodb.BasicDBObject;

public class Address extends BasicDBObject {

   public Address() {
  }

  public Address(String streetName, String postalCode, String place, String country) {
    put("street", streetName);
    put("postalcode", postalCode);
    put("place", place);
    put("country", country);
  }

  public String place(){
    return (String) get("place");
  }
   

}
