package org.example;

public class Main {

    public static void main(String[] args) {
        int storageCapacity = 3;
        //int itemCount = 10;

        Storage storage = new Storage(storageCapacity);
        Thread producerThread = new Thread(new Producer(storage, 7));
        Thread consumerThread = new Thread(new Consumer(storage, 7));

        Thread producerThread1 = new Thread(new Producer(storage, 3));
        Thread consumerThread1 = new Thread(new Consumer(storage, 3));

    }
}
