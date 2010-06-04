package no.kh.mongo.mungbean;

import mungbean.ObjectId;

public class Person {
  private String name;
  private ObjectId _id = new ObjectId();
  private String address;


  public Person(String name, String address){
    this.name = name;
    this.address = address;
  }

  public String getAddress(){
    return address;
  }

  public ObjectId getId(){
    return _id;
  }
}
