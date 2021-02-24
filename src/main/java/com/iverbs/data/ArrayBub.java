package com.iverbs.data;

public class ArrayBub {
    
    private long[] a;
    private int nElems;
    
    public ArrayBub(int max) {
        a = new long[max];
        nElems=0;

    }
    
    public ArrayBub(int[] arr) {
        this(arr.length);
        for(int item: arr) {
            this.insert(item);
        }
    }
    
    public void insert(int value) {
        a[nElems++]=value;    
    }

    public void display() {
        for(int i=0; i<nElems; i++) {
            System.out.println(a[i]);
        }
    }
    
    public void bubbleSort() {
        int out, in;
        for(out=nElems-1;out>1;out--) {
            for(in=0;in<out;in++) {
                if(a[in]>a[in+1]) {
                    swap(in, in+1);
                }
            }
        }
    }
    
    public void swap(int one, int two) {
        long tmp=a[one];
        a[one]=a[two];
        a[two]=tmp;
    }
    
    public long[] getArray() {
        return a;
    } 
}
