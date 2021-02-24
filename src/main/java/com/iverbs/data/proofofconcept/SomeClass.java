package com.iverbs.data.proofofconcept;

public class SomeClass {
    
    public int value;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SomeClass other = (SomeClass) obj;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SomeClass [value=" + value + "]";
    }

    
}
