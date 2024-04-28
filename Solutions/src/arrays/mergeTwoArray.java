package arrays;

import java.util.*;

public class mergeTwoArray {

    public static int[] mergeTwoArray(int[] a , int[] b){
        Set<Integer> set =  new HashSet<Integer>();
        for(int num :a){
            set.add(num);
        }
        for(int num :b){
            set.add(num);
        }
        int[] array = new int[set.size()];
       Iterator<Integer> it =  set.iterator();
       while(it.hasNext()){
           array[it.next()]=it.next();
       }
        return array;
    }
}
