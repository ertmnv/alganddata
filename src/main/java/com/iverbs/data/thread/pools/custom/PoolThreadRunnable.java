package com.iverbs.data.thread.pools.custom;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;
    
    public PoolThreadRunnable(BlockingQueue queue) {
        taskQueue = queue;
    }
    
    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while(!isStopped) {
            try {
                
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
                
            } catch (Exception e) {
                // log or otherwise report exception
                // but keep pool alive 
            }
        }
    }
    
    public synchronized void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }
    
    public synchronized boolean isStoped() {
        return isStopped;
    }

    
}
