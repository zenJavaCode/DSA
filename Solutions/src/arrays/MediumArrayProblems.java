package arrays;

import java.util.HashSet;

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
}
