package exceptions;

import java.util.*;

public class FocusMateOne {

    public static void main(String[] args) {
        /*TODO :  Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to
            k. subarray is a contiguous non-empty sequence of elements within an array.
            */


    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();

        int preSum = 0;
        int count = 0;
        map.put(0, 1); //setting 0 in the map

        for (int i = 0; i < n; i++) {
            preSum += nums[i];

            int remove = preSum - k;

            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    /*TODO : Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
            You must write an algorithm that runs in O(n) time.*/


    public int longestConsecutive(int[] nums) {
        int longest =0;
        Set<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }
        for(int it :set){
            if(!set.contains(it-1)){
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
    return longest;
    }

    /*TODO Given an array arr of n positive integers, your task is to find all the leaders in the array.
       An element of the array is considered a leader if it is greater than all the elements on its right side
       or if it is equal to the maximum element on its right side. The rightmost element is always a leader.*/

//    static ArrayList<Integer> leaders(int n, int arr[]) {
//        // Your code here
//        ArrayList<Integer> list = new ArrayList<>();
//        int max = arr[n - 1];
//
//        for(int i=n-2;i>=0;i-- ){
//            if(arr[i]>max){
//                list.add(arr[i]);
//                max = arr[i];
//            }
//        }
//            List list1 =  Collections.reverse(list) ;
//        return list1;
//    }
}
