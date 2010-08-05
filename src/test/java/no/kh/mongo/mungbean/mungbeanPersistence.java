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


  @Before
  public void create() {
    test = new Mungbean(new Settings(), "localhost", 27017).openDatabase("test");
    testPerson = new Person("Knut Haugen", "josefines gate");
    persons = test.openCollection("persons", Person.class);

  }

  @Test
  public void storePerson(){
    persons.save(testPerson);
    assertEquals(persons.query(new Query().field("name").is("Knut Haugen")).size(), 1);

  }


  @Test
  public void personGetGeneratedIdAndAddress(){
    persons.save(testPerson);
    Person found = persons.query(new Query().field("name").is("Knut Haugen")).get(0);
    assertNotNull(found.getId());
    assertEquals(found.getAddress(), "josefines gate");

  }


  @After
  public void destroy() {
    test.dbAdmin().dropDatabase();
  }


}
