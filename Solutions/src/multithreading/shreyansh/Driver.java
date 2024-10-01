package multithreading.shreyansh;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Going inside main method "+Thread.currentThread().getName());
//        MultithreadingByShreyansh runnableObject = new MultithreadingByShreyansh();
//        Thread thread = new Thread(runnableObject);
//        thread.start();
//        System.out.println("Finish main method "+Thread.currentThread().getName());

//        MultithreadingByShreyanshThread threadObject = new MultithreadingByShreyanshThread();
//        threadObject.start();
//        System.out.println("Finish main method "+Thread.currentThread().getName());


        MonitorLockExample obj = new MonitorLockExample();
        MonitorThread1 runnable = new MonitorThread1(obj);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(() -> {obj.task2();});
        Thread t3 = new Thread(() -> {obj.task3();});

        t1.start();
        t2.start();
        t3.start();

    }
}
