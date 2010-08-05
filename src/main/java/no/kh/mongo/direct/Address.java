package no.kh.mongo.direct;

import com.mongodb.DBObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Address implements DBObject {

  private Map map = new LinkedHashMap();

  public Address() {
  }

  public Address(String streetName, String postalCode, String place, String country) {
    map.put("street", streetName);
    map.put("postalcode", postalCode);
    map.put("place", place);
    map.put("country", country);
  }

  public String place(){
    return (String)map.get("place");
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
