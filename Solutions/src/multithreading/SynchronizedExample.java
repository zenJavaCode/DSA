package multithreading;

public class SynchronizedExample{

    public static synchronized void staticMethod(){
        try{
            Thread.sleep(2000);
            System.out.println("slept in static method");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void instanceMethod(){
        System.out.println("instance method start");
        try{
            Thread.sleep(2000);
            System.out.println("slept in instance method");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("InstanceMethod end");
    }

    public static void main(String[] args) {
        SynchronizedExample instance = new SynchronizedExample();
        Thread t1 = new Thread(() -> SynchronizedExample.staticMethod());
        Thread t2 = new Thread(instance::instanceMethod);

        t1.start();
        t2.start();
    }
}
