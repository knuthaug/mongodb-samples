package no.kh.mongo;

import com.mongodb.BasicDBObject;


public class Person extends BasicDBObject {

    public Person(String fullName) {
        put("name", fullName);
    }

    
}
