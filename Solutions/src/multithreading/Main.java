package multithreading;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Sample s = new Sample();
        Thread th = new Thread(() ->{
           try{
               s.doSomething();
           } catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        th.setName("FirstThread");
        th.start();
        Thread th1 = new Thread(() ->{
            try{
                s.doSomething();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        th1.setName("SecondThread");
        th1.start();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return s.doSomething();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            try{
                return s.deliveryService();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> combinedFuture= future1.thenCombine(future2,(result1,result2) -> { return result1 +result2;
        });

    }



}
