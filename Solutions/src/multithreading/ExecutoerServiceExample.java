package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutoerServiceExample {


    public static void main(String[] args) {
        Sample s = new Sample();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(() -> {
            try{
                s.deliveryService();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }

}

