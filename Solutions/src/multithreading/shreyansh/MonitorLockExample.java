package multithreading.shreyansh;

public class MonitorLockExample {

    public synchronized  void task1(){

        try{
            System.out.println("inside task1"+Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized  void task2(){
        System.out.println("task 2 but before synchronization"+Thread.currentThread().getName());
        synchronized (this){
            System.out.println("task 2 inside synchronization"+Thread.currentThread().getName());
        }
    }

    public  void task3(){
        System.out.println("task 3"+Thread.currentThread().getName());
    }
}
