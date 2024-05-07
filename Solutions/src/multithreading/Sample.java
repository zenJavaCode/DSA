package multithreading;

public class Sample {

public String doSomething() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("slept for 5 seconds.");
    System.out.println(Thread.currentThread().getName());
    return "Your Pizza is ready";
}

    public String deliveryService() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("slept for 5 seconds.");
        System.out.println(Thread.currentThread().getName());
        return "Your Pizza is delivered";
    }
}
