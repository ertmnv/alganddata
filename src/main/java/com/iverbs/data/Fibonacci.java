package com.iverbs.data;

import java.util.HashMap;

public class Fibonacci {
    
    
    public HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    /*
    public int getFibonacciNumberRecursively(int n) {
        
        System.out.println("first");
        
        if(n==0 || n==1) {
            return n;
        }
        
        return getFibonacciNumberRecursively(n-2) + getFibonacciNumberRecursively(n-1);
    }
    
    public int getFibonacciNumberRecursivelyWithMem(int n) {
        
        System.out.println("second");
        
        if(n==0 || n==1) {
            return n;
        }
        
        if (hm.containsKey(n)) {
            return hm.get(n);    
        }
        
        int result = getFibonacciNumberRecursivelyWithMem(n-2) + getFibonacciNumberRecursivelyWithMem(n-1);
        
        hm.put(n, result);
        
        return result; 
    }
    
    public int getFibonacciNumberRecursivelyLoop(int n) {
        
        int a = 1, b = 0, tmp = 0;
        
        for (int i = 2; i <= n; i++) {
            System.out.println("third");
            tmp = a + b;
            b = a;
            a = tmp;
        }
        
        return a;
    }
    */
    
    
    public int getFibonacciNumberRecursively(int n) {
        if (n==0 || n==1) {
            return n;
        }
        
        return getFibonacciNumberRecursively(n-2) + getFibonacciNumberRecursively(n-1); 
    }
    
    
    public int getFibonacciNumberRecursivelyLoop(int n) {
        int sum=0, n1=0, n2=1;
        if (n==0) return 0;
        if (n==1) return 1;
        for (int i=2;i<=n;i++) {
           sum=n1+n2;
           n1=n2;
           n2=sum;
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
        
        Fibonacci fib = new Fibonacci();
        
        System.out.println(fib.getFibonacciNumberRecursively(6));
        //System.out.println(fib.getFibonacciNumberRecursivelyWithMem(6));
        System.out.println(fib.getFibonacciNumberRecursivelyLoop(6));
        
        Thread t = new Thread();
    }

}
