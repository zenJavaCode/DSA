package multithreading.shreyansh.realExample.sharedExample;

public class SharedResource {

 boolean isItemPresent = false;

 public synchronized void addItem(){
     isItemPresent = true;
     System.out.println("Producer Thread calling notifyAll method");
     notifyAll();
 }

 public synchronized void consumeItem() throws InterruptedException {
     System.out.println("Consumer Thread inside consumeItem method");
    if(!isItemPresent){
        System.out.println("Consumer Thread is waiting...");
        wait();
    }else{
        isItemPresent =false;
    }
 }
}
