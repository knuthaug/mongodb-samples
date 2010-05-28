package no.kh.mongo;

import com.mongodb.DBObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Person implements DBObject {

    Map map;

    public Person () {
        map = new LinkedHashMap();
    }

    public Person(String fullName) {
        this();
        put("name", fullName);

    }

    public Object put(String s, Object o) {
        return map.put(s, o);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void putAll(DBObject dbObject) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void putAll(Map map) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object get(String s) {
        return map.get(s);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Map toMap() {
        return map;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object removeField(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean containsKey(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean containsField(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Set<String> keySet() {
        return map.keySet();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void markAsPartialObject() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isPartialObject() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }



    
}
