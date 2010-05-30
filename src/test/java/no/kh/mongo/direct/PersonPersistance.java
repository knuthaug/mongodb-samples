package no.kh.mongo.direct;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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

        Person test = new Person("Knut Haugen");
        persons.insert(test);
        assertNotNull(test.get("_id"));


    }

    @Test
    public void retrievePersonFromDatabase(){
        Person test = new Person("Knut Haugen");
        persons.insert(test);

        Person test2 = (Person) persons.findOne();
        assertEquals(test.get("name"), test2.get("name"));
    }

    @After
    public void tearDown(){
        persons.drop();
    }

}
