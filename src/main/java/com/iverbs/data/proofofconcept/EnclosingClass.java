package com.iverbs.data.proofofconcept;

public class EnclosingClass {
    
    int enclosingClassParam = 11;
    
    int par = 8;
    
    final int svw; 
    
    {
    //    svw = 9;
    }
    
    public EnclosingClass() {
        svw = 9;
    }

    
    
    public void setSVW() {
      //  svw = 7;
    } 
    
    
    
    public class NestedClass {
        int par =9;
        
        //public static  int sv = 91; - The field sv cannot be declared static in a non-static inner type, unless initialized with a constant expression
        
        public int getEnclosingClassParam() {
            return enclosingClassParam;
        }
    }
    
    public void m(SomeInterfaceForInnerClasses s) {
        s.someMethod();
    }
    
    public static void main(String[] args) {
        EnclosingClass ec = new EnclosingClass();
        EnclosingClass.NestedClass nc = ec.new NestedClass();
        System.out.println(nc.par);
        ec.m(new SomeInterfaceForInnerClasses(){
            public void someMethod() {
                System.out.println("lll");            
            }
        }); 
        System.out.println(EnclosingClass.NestedClass.sv);
    }
}
