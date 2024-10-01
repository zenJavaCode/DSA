package multithreading.shreyansh;

public class MultithreadingByShreyanshThread extends Thread{

    @Override
    public void run() {
        System.out.println("code executed by Thread:"+Thread.currentThread().getName());
    }
}
