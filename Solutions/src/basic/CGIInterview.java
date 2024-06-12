package basic;

import java.util.Arrays;
import java.util.HashMap;

public class CGIInterview {

    public static void main(String[] args) {

//        int[] arr = {1,2,3,4,5,6,7,8};
//        Arrays.stream(arr).filter(n -> n %2 !=0).map(n -> n*n).forEach(System.out::println);

        int[] nums = {2,7,11,15};
        int target = 9;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int rem = Math.abs(nums[i] -target);
            if(map.containsKey(rem)){
                System.out.println(i+" "+map.get(rem));
                break;
            }else{
                map.put(nums[i],i);
            }


        }

    }
}
