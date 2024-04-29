package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MediumArrayProblems {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int longestLength = longestSubStringWithoutRepeatingCharacters(str);
        System.out.println("Length of the  longest substring without repeating characters: " + longestLength);

    }


    /*TODO: Maximum Sum Subarray of Size K:*/

    public static int maxSumSubArray(int k, int[] nums) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
        windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
           windowSum += nums[i] - nums[i - k];
           maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /*TODO Longest Substring Without Repeating Characters:*/

    public static int longestSubStringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < n) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
                maxLen = Math.max(maxLen, end - start);
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }

    /*TODO : longest subarray with sum k includes positive numbers only*/

    public static int lengthOfLongestSubArrayWithSumK(int[] a ,int k){

       int n = a.length;
       int sum =0;
       int maxLen =0;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i =0;i<n;i++){

           sum+=a[i];

           if(sum ==k){
               maxLen = Math.max(maxLen, i + 1);
           }
           int rem = sum-k;
           if(map.containsKey(rem)){
               int len = i - map.get(rem);
              maxLen = Math.max(maxLen, len);
           }

           if (!map.containsKey(sum)) {
               map.put(sum, i);
           }

       }
return maxLen;

    }

}
