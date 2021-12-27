package hw13;

import java.util.ArrayList;

public class MltThread {
    public static void main(String[] args) {
        final int maxListSize = 5;
        final int maxProducerDelay = 1000;
        final int maxConsumerDelay = 1000;
        ArrayList<Integer> list = new ArrayList<>();
        Producer producer = new Producer(list, maxProducerDelay, maxListSize);
        Client consumer = new Client(list, maxConsumerDelay);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
