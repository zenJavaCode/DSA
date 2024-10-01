package multithreading.shreyansh.realExample;

public class SharedResource {

    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by: "+Thread.currentThread().getName()+ " add invoking all threads which are ");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume item invoked by : "+Thread.currentThread().getName()+ " add invoking all threads which are ");
    // TODO: using while loop to avoid the "spurious wake-up" sometimes because of system noise.
    while(!itemAvailable){
        try{
            System.out.println("Thread"+Thread.currentThread().getName()+" waiting for Item");
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
        System.out.println("Item Consumed by "+Thread.currentThread().getName()+ " add invoking all threads which are ");
        itemAvailable = false;
    }


}
