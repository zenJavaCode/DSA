package multithreading.practical.string;

public class WorldPrinter implements Runnable{
    @Override
    public void run() {
        for(int i =1;i<=10;i+=2){
            System.out.println("World");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    }
}
