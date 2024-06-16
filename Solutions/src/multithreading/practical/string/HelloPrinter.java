package multithreading.practical.string;

public class HelloPrinter implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<=10;i+=2){
            System.out.println("Hello");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
