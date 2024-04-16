package org.example;

public class Main {

    public static void main(String[] args) {
        int storageCapacity = 3;
        int itemCount = 5;
        int producerConsumerCount = 2;

        Storage storage = new Storage(storageCapacity);
        for(int i = 0; i < producerConsumerCount; i++){
            Thread consumerThread = new Thread(new Consumer(storage, itemCount));
            Thread producerThread = new Thread(new Producer(storage, itemCount));
        }
    }
}
