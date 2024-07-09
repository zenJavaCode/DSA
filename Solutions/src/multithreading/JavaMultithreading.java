package multithreading;

public class JavaMultithreading extends Thread {

    int i;

    synchronized void SharedMethod()
    {
        Thread t = Thread.currentThread();

        for(i = 0; i <= 1000; i++)
        {
            System.out.println(t.getName()+" : "+i);
        }
    }

    public void run() {
    for(int i =0;i<=1000;i++){
        System.out.print(i+" ");
    }
    }

    public static void main(String[] args) {
       final JavaMultithreading multithreading = new JavaMultithreading();
        Thread t1 = new Thread("Thread - 1"){
            @Override
            public void run()
            {
                multithreading.SharedMethod();
            }
        };

        Thread t2 = new Thread("Thread - 2")
        {
            @Override
            public void run()
            {
                multithreading.SharedMethod();
            }
        };

        t1.start();

        t2.start();


//        multithreading.start();
//        multithreading.setPriority(1);
//        Thread2 t2 = new Thread2();
//        t2.start();
//        t2.setPriority(5);
//        Thread1 t1 = new Thread1();
//        t1.call();
//        t2.setPriority(10);
    }




}
