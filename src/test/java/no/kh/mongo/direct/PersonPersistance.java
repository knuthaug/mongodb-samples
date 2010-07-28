package no.kh.mongo.direct;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PersonPersistance {

    DB testDb;
    DBCollection persons;

    @Before
    public void setUp() throws UnknownHostException {
       Mongo m = new Mongo( "127.0.0.1" , 27017 );

       testDb = m.getDB( "test" );
       persons = testDb.getCollection("persons");
       persons.setObjectClass(Person.class);
    }

    @Test
    public void insertPersonSavesPersonToDatabase () {

        Person test = new Person("Knut Haugen",
                                 new Address("Josefines gate", "0401",
                                             "oslo", "Norge"));
        persons.insert(test);
        assertNotNull(test.get("_id"));

    }


    @Test
    public void personWithDocumentNotMatchingObject(){
      BasicDBObject tmp = new BasicDBObject();
      tmp.append("foo", "value");
      persons.insert(tmp);

      Person test2 = (Person) persons.findOne();
      assertEquals(test2.get("foo"), "value");
      assertNull(test2.get("name"));
    }

    @Test
    public void retrievePersonFromDatabase(){
        Person test = new Person("Knut Haugen",
                                  new Address("Josefines gate", "0401",
                                              "oslo", "Norge"));
        persons.insert(test);

        Person test2 = (Person) persons.findOne();
        assertEquals(test.get("name"), test2.get("name"));
        assertEquals( ((Address) test.get("address")).place(), "oslo");
    }

    @After
    public void tearDown(){
        persons.drop();
    }

}
