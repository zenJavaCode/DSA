package multithreading.shreyansh;

public class MultithreadingByShreyansh implements Runnable {
    @Override
    public void run() {
        System.out.println("code executed by thread"+ Thread.currentThread().getName());
    }
}
