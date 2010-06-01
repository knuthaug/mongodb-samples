package no.kh.mongo.mungbean;

import mungbean.DBCollection;
import mungbean.Database;
import mungbean.Mungbean;
import mungbean.Settings;
import mungbean.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class mungbeanPersistence {

  private Database test;
  private Person testPerson;
  private DBCollection<Person> persons;


  @Test
  public void storePerson(){
    persons.save(testPerson);
    assertEquals(persons.query(new Query().field("name").is("Knut Haugen")).size(), 1);

  }


  @Test
  public void personGetGeneratedId(){
    persons.save(testPerson);
    assertNotNull(persons.query(new Query().field("name").is("Knut Haugen")).get(0).getId());

  }


  @Before
  public void create() {
    test = new Mungbean(new Settings(), "localhost", 27017).openDatabase("test");
    testPerson = new Person("Knut Haugen");
    persons = test.openCollection("persons", Person.class);

  }

  @After
  public void destroy() {
    test.dbAdmin().dropDatabase();
  }


}
