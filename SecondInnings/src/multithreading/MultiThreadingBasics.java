package multithreading;

public class MultiThreadingBasics  extends Thread{

    public void run(){
        System.out.println("Thread is running.");
    }

    public static void main(String[] args) {
        MultiThreadingBasics basics = new MultiThreadingBasics();
        basics.start();

        System.out.println(basics.getName());

        basics.run();
        System.out.println(basics.getName());
    }

}
