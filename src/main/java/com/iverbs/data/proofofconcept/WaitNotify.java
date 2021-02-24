package com.iverbs.data.proofofconcept;

public class WaitNotify {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Store {
    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        product--;
        System.out.println("Consumer buy one product");
        System.out.println("product in store" + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 1) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        product++;
        System.out.println("Consumer add one product to store");
        System.out.println("Products in the store" + product);
        notify();

    }
}

class Producer implements Runnable {

    Store store;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }

}

class Consumer implements Runnable {

    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }

}