package no.kh.mongo.morphia;


import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertNotNull;

public class PersistanceThroughMorphia {

    Morphia morph;
    Mongo mongo;
    DBCollection persons;

    @Before
    public void setUp() throws UnknownHostException {
       morph = new Morphia();
       mongo = new Mongo("127.0.0.1", 27017);
       morph.map(Person.class).map(Address.class);
       DB testDb = mongo.getDB( "test" );
       persons = testDb.getCollection("persons");
    }

    @Test
    public void storePersonThroughMorphiaMapping () {

        Person test = new Person();
        test.setName("Knut Haugen");
        test.setStreetName("Josefines gate");
        persons.save(morph.toDBObject(test));
        Person test2 = (Person) morph.fromDBObject(Person.class, persons.findOne());
        assertNotNull(test2.getId());

    }

    

    @After
    public void tearDown(){
        //persons.drop();
    }


}
