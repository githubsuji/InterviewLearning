package com.interthread.legacyway;
import java.util.Queue;

import org.apache.log4j.Logger;

public class Consumer extends Thread {
    private static final Logger logger = Logger.getLogger(Consumer.class);
    private final Queue<Integer> sharedQ;

    public Consumer(Queue<Integer> sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
    	logger.debug("consumer started");
        while(true) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        logger.debug("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number =  sharedQ.poll();
                logger.debug("consuming : " + number );
                sharedQ.notify();
              
                //termination condition
                if(number == 3){break; }
            }
        }
    }
}


