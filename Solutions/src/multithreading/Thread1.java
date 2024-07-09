package multithreading;

import java.util.concurrent.Callable;

public class Thread1 implements Callable {
    @Override
    public Object call() {
        for(int i=3001;i<=4000;i++){
            System.out.print(i+" ");
        }
        return -1;
    }
}
