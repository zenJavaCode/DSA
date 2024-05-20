package arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayRevisionTwo {


    /*TODO :- Count Consecutive Triplets with Sum Equal to K */

    public static void sumOfTriplet(int[] a,int k){


    }

    /*TODO Given an array of integers and an integer K
       find the length of the longest subarray that sums to K */

    public static int lengthOfLongestSubArrayWithSumK(int[] arr, int k){
        int currentSum =0;
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i =0;i<arr.length;i++){
            currentSum += arr[i];
            int remaining = k-currentSum;
            if(map.containsKey(remaining)){
                maxLength = Math.max(maxLength, i- map.get(remaining));
            }
            map.putIfAbsent(currentSum, i);
        }
        return maxLength;
    }

    /*TODO  Given a string, find the length of the longest substring without repeating characters.*/

    public static int lengthOfSubStringWithoutRepeatingCharactors(String s ){
        int maxLength=0;
        int left =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int right =0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            maxLength = Math.max(maxLength,right -left +1);
        }
        return  maxLength;

    }

    /*TODO You are given an array 'a' of size 'n' and an integer 'k'.
           Find the length of the longest subarray of 'a' whose sum is equal to 'k'.*/

    public static int lengthOfLongestSubArrayWithSumK(int[] arr,int k,int n){
        int start = 0;
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > k) {
                sum -= arr[start];
                start++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, i - start + 1);
            }
        }
        return maxLength;

    }




}
