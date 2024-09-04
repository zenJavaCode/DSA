package multithreading.shreyansh.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {


    private Queue<Integer> sharedBuffer;

    private int bufferSize;

    public SharedResource( int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized  void produce(int item) throws Exception{

        // TODO : If buffer is full, wait for the consumer to consume it
        while(sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full please wait for some time for consumer to consume it.");
        wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced " + item);
        // Notify the consumer that there are items to be consumed now
        notify();
    }

    public synchronized int consume() throws Exception{
        // TODO : if buffer is empty then producer have to produce items.
        while(sharedBuffer.size() == 0) {
            System.out.println("Buffer is full please wait for consumer to consume it.");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed " + item);
        // TODO : Notify producer that there is buffer in the queue now.
        notify();
        return item;
    }
}
