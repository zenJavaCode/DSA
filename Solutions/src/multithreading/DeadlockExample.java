package multithreading;

public class DeadlockExample {
    private final Object resource1 = new Object();
    private final Object resource2 = new Object();

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();
        example.createDeadlock();
    }

    private void createDeadlock() {

        Thread t1 = new Thread(() -> {

            synchronized (resource1) {
                System.out.println("Thread 1 locked resource 1");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                // Adding delay to make sure Thread 1 locks resource 1
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
