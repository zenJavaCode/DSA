package multithreading.practical;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<=10;i+=2){
            System.out.println("Even: "+i);
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }

    }
}
