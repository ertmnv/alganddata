package com.iverbs.data.proofofconcept;

import java.util.HashMap;

public class LostKeyTest {
    
    
    public static void main(String[] args) {
        
        SomeClass s1 = new SomeClass();
        s1.value = 1;
        
        SomeClass s2 = new SomeClass();
        s2.value = 2;
        
        SomeClass s3 = new SomeClass();
        s1.value = 1;
        
        SomeClass s4 = new SomeClass();
        s2.value = 4;
        
        HashMap<SomeClass, SomeClass> hm = new HashMap<SomeClass, SomeClass>();
        
        hm.put(s1, s2);
        
        hm.put(s3, s4);
        
        System.out.println(hm.get(s1));
        
        s2 = new SomeClass();
        
        s2.value = 99;
        
        System.out.println(hm.get(s1));
    } 

}
