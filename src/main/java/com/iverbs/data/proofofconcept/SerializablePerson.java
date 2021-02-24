package com.iverbs.data.proofofconcept;

public class SerializablePerson implements java.io.Serializable {

    String name;
    
    public SerializablePerson(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerializablePerson [name=" + name + "]";
    }
    
    
}
