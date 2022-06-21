package com.neuresys.formation.java8.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    private static final int NUM_OF_MSGS = 20;
    private static final BlockingQueue<String> queue 
                                              = new ArrayBlockingQueue<String>(5);
    private static ExecutorService producerPool = Executors.newFixedThreadPool(3);
    private static ExecutorService consumerPool = Executors.newFixedThreadPool(1);

    private static Logger logger =  Logger.getLogger(ProducerConsumer.class.getName());

    public static void main(String[] args) {
        Runnable producerTask = () -> {
            try {
                queue.put("test Message");
                System.out.println(Thread.currentThread().getName() 
                                   + " put message queue.size() " + queue.size());
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        };
        Runnable consumerTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName() 
                                   + " received msg " + queue.take());

            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        };
        try {
            for (int i = 0; i < NUM_OF_MSGS; i++) {
                producerPool.submit(producerTask);
            }
            for (int i = 0; i < NUM_OF_MSGS; i++) {
                consumerPool.submit(consumerTask);
            }
        } finally {
            if (producerPool != null) {
                producerPool.shutdown();
            }
            if (consumerPool != null) {
                consumerPool.shutdown();
            }
        }
    }

}