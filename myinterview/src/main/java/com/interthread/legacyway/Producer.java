package com.interthread.legacyway;
import java.util.Queue;

import org.apache.log4j.Logger;
public class Producer extends Thread {
    private static final Logger logger = Logger.getLogger(Producer.class);
    private final Queue<Integer> sharedQ;

    public Producer(Queue<Integer> sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
    	logger.debug("producer started");
        for (int i = 0; i < 4; i++) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        logger.debug("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                logger.debug("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}


