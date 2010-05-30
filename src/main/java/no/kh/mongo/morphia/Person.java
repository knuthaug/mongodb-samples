package no.kh.mongo.morphia;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Person {

    @Id
    private String id;
    private String name;

    @Embedded
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Person(){
        address = new Address();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetName(String streetName) {
        address.setStreetName(streetName);
    }
}
