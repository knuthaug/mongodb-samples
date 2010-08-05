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


  public Person() {
        address = new Address("", "", "", "");
    }

    public Person(Address newAddress){
        address = newAddress;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setId(String newId) {
        id = newId;
    }


    public void setName(String newName) {
        name = newName;
    }


    public void setAddress(Address newAddress) {
        address = newAddress;
    }

}
