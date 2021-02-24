package com.iverbs.data.proofofconcept;

public class ClassRelatedToEnclosingClass {
    
    public EnclosingClass.NestedClass nc;
    
    public ClassRelatedToEnclosingClass(EnclosingClass.NestedClass nc) {
        this.nc = nc;
    }
    
    public int getEncClassPar() {
        return this.nc.getEnclosingClassParam();
    }
    
    
    public static void main(String[] args ) {
        
        EnclosingClass ec = new EnclosingClass();
        EnclosingClass.NestedClass nc = ec.new NestedClass();
        ClassRelatedToEnclosingClass cr = new ClassRelatedToEnclosingClass(nc);
        
        System.out.println(cr.getEncClassPar());
        
        ec.enclosingClassParam = 77;
        
        
        System.out.println(cr.getEncClassPar());
    }

}
