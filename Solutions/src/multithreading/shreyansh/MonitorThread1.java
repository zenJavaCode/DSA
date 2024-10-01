package multithreading.shreyansh;

public class MonitorThread1 implements Runnable {

    MonitorLockExample obj;

    MonitorThread1(MonitorLockExample obj){
    this.obj = obj;
    }
    @Override
    public void run() {
    obj.task1();


    }
}
