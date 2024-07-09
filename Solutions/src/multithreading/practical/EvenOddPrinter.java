package multithreading.practical;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddPrinter {

    private static final int MAX_NUMBER = 10;
    private static int counter = 0;

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new EvenPrinter());
        service.execute(new OddPrinter());
        service.shutdown();
    }


    private static class EvenPrinter implements Runnable {

        @Override
        public void run() {
            synchronized (EvenOddPrinter.class) {
                while (counter <= MAX_NUMBER) {
                    if (counter % 2 == 0) {
                        System.out.println("Even: " + counter);
                        counter++;
                        EvenOddPrinter.class.notify();
                    } else {
                        try {
                            EvenOddPrinter.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class OddPrinter implements Runnable{

        @Override
        public void run() {
            synchronized (EvenOddPrinter.class){
                while(counter<=MAX_NUMBER){
                    if(counter % 2 !=0){
                        System.out.println("Odd: "+counter);
                        counter++;
                        EvenOddPrinter.class.notify();
                    }else{
                        try{
                            EvenOddPrinter.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
