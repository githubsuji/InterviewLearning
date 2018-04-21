package com.interview.myinterview;

import java.util.LinkedList;
import java.util.Queue;

import com.interthread.legacyway.Consumer;
import com.interthread.legacyway.Producer;



public class InterThreadCommunicationExample {
	public static void main(String args[]) {

        final Queue<Integer> sharedQ = new LinkedList<Integer>();

        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);

        producer.start();
        consumer.start();

    }

//https://logging.apache.org/log4j/1.2/download.html
//Read more: http://javarevisited.blogspot.com/2013/12/inter-thread-communication-in-java-wait-notify-example.html#ixzz5DGTLAkRV
	//http://javarevisited.blogspot.in/2012/02/producer-consumer-design-pattern-with.html#axzz5DGThaAlH
	//http://javarevisited.blogspot.in/2014/10/how-to-use-locks-in-multi-threaded-java-program-example.html
}
