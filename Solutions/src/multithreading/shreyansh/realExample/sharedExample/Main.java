package multithreading.shreyansh.realExample.sharedExample;

public class Main {

    public static void main(String[] args) {


        SharedResource sharedResourceObj = new SharedResource();

        Thread producerThread = new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResourceObj.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            try {
                sharedResourceObj.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
