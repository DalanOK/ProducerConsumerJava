package org.example;

public class Main {

    public static void main(String[] args) {
        int storageCapacity = 3;
        int itemCount = 10;
        int consumerCount = 4;
        int producerCount = 2;

        int consumerAdd = itemCount % consumerCount;
        int producerAdd = itemCount % producerCount;

        Storage storage = new Storage(storageCapacity);

        if(consumerAdd > 0){
            for(int i = 0; i < consumerCount; i++){
                if(i == consumerCount - 1){
                    Thread consumerThread = new Thread(new Consumer(storage, (itemCount / consumerCount) + consumerAdd));
                }
                else{
                    Thread consumerThread = new Thread(new Consumer(storage, (itemCount / consumerCount)));
                }
            }
        }
        else{
            for(int i = 0; i < consumerCount; i++){
                Thread consumerThread = new Thread(new Consumer(storage, (itemCount / consumerCount)));
            }
        }

        if(producerAdd > 0){
            for(int i = 0; i < producerCount; i++){
                if(i == producerCount - 1){
                    Thread producerThread = new Thread(new Producer(storage, (itemCount / producerCount) + producerAdd));
                }
                else {
                    Thread producerThread = new Thread(new Producer(storage, (itemCount / producerCount)));
                }
            }
        }
        else{
            for(int i = 0; i < producerCount; i++){
                Thread producerThread = new Thread(new Producer(storage, (itemCount / producerCount)));
            }
        }
    }
}
