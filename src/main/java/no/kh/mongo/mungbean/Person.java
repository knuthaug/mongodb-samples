package no.kh.mongo.mungbean;

import mungbean.ObjectId;

public class Person {
  private String name;
  private ObjectId _id = new ObjectId();

  public Person(String name){
    this.name = name;
  }

  public ObjectId getId(){
    return _id;
  }
}
