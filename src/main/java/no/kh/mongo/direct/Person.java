package no.kh.mongo.direct;

import com.mongodb.BasicDBObject;

import java.util.LinkedHashMap;

public class Person extends BasicDBObject {


    public Person () {

    }

    public Person(String fullName, Address newAddress) {
        put("name", fullName);
        put("address", newAddress);

    }

}
