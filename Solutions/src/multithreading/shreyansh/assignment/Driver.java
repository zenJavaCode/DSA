package multithreading.shreyansh.assignment;

public class Driver {



    public static void main(String[] args) {

        SharedResource sharedBuffer = new SharedResource(3);
        Thread producerThread = new Thread(()->{
           try{
               for(int i =1;i<=6;i++){
                   sharedBuffer.produce(i);
               }
           } catch (Exception e){
               e.printStackTrace();
           }
        });

        Thread consumerThread = new Thread(()->{
            try{
                for(int i =1;i<=6;i++){
                    sharedBuffer.consume();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
