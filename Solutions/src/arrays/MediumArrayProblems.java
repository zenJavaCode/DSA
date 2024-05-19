package arrays;

import java.util.*;

public class MediumArrayProblems {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int longestLength = longestSubStringWithoutRepeatingCharacters(str);
        System.out.println("Length of the  longest substring without repeating characters: " + longestLength);

        int[] v = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        int n = majorityElement(v);
        System.out.println(n);

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

/*TODO find minimum sub array sum*/
    public static int minSumSubArray(int k, int[] nums) {

        int minSum = Integer.MAX_VALUE;
        int windowSum = 0;
        for(int i =0;i<k;i++){
            windowSum += nums[i];
        }
        minSum = windowSum;
        for(int i =k;i<nums.length;i++){
            windowSum += nums[i] - nums[i-k];
            minSum = Math.min(minSum, windowSum);
        }
        return minSum;

    }

    /*  TODO Find the longest substring with k distinct characters.*/

    static Integer longestSubstringWithoutRepeatingCharacters(String str,int k) {
    return null;

    }









    /*TODO You are given an array 'arr' of length 'n', consisting of integers.
        A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or
        more integers from the beginning and 0 or more integers from the end of an array.
        Find the sum of the subarray (including empty subarray) having maximum sum among all subarrays.
        The sum of an empty subarray is 0.*/

    public static long sumOfMaxSubArray(int[] arr, int n) {
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        if (maxSum < 0) {
            maxSum = 0;
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
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }

    /*TODO: Count All Sub Array of sum k*/

    public static int numberOfSubArrayOfSumK(int[] arr, int k) {
        int n = arr.length ;
        int count =0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0; i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }

    /*TODO : longest subarray with sum k includes positive numbers only*/

    public static int lengthOfLongestSubArrayWithSumK(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    /*TODO : Check if a pair with given sum exists in Array*/
    public static Boolean isTwoSumPresent(int[] n, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            int num = n[i];
            int sumNeeded = k - num;
            if (map.containsKey(sumNeeded)) {
                return true;
            }
            map.put(n[i], i);
        }
        return false;
    }

    /*TODO : Check if a pair with given sum exists in Array*/

    public static Boolean twoSumUsingTwoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return false;
    }

    /*TODO You have been given an array/list 'arr' consisting of 'n' elements.
        Each element in the array is either 0, 1 or 2.
            Sort this array/list in increasing order.
            Do not make a new array/list. Make changes in the given array/list.
            Example :
            Input: 'arr' = [2, 2, 2, 2, 0, 0, 1, 0]
            Output: Final 'arr' = [0, 0, 0, 1, 2, 2, 2, 2]
            */

    public static void threePointers(int[] nums) {
        Arrays.sort(nums);
    }

    /*TODO You are given an array 'a' of 'n' integers.
       A majority element in the array ‘a’ is an element that appears more than 'n' / 2 times.
       Find the majority element of the array.
       It is guaranteed that the array 'a' always has a majority element.*/

    public static int majorityElement(int[] num, int n) {
        int len = num.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int currLen = 0;
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                maxLength = Math.max(maxLength, map.get(num[i]));
            }
            if (maxLength >= len) {
                return num[i];
            }
            if (!map.containsKey(num[i])) {
                map.put(num[i], map.getOrDefault(num[i], 0) + 1);
            }

        }
        return -1;
    }

    public static int majorityElement(int[] v) {
        // Write your code here
        int len = v.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < v.length; i++) {
            if (map.containsKey(v[i])) {
                map.put(v[i], map.get(v[i]) + 1);
                maxLength = Math.max(maxLength, map.get(v[i]));
            }
            if (maxLength >= len) {
                return v[i];
            }
            if (!map.containsKey(v[i])) {
                map.put(v[i], map.getOrDefault(v[i], 0) + 1);
            }
        }
        return -1;
    }

    /*TODO longestSubarrayWithSumK Using Sliding Window*/

    public static int longestSubarrayWithSumK(int[] a, long k) {

        int left = 0, right = 0;
        long sum = 0;
        int max = 0;
        while (right < a.length) {
            sum += a[right++];
            if (sum > k) {
                sum -= a[left++];
            }
            if (sum == k) {
                max = Math.max(max, right - left);
            }
        }
        return max;
    }



    /*TODO Best time to buy an sell a stock
           Return the best profit you made. */


    public static int bestTimeToBuySell(int[] a) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : a) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /*TODO Rearrange the array in alternating positive and negative items in a array*/

    public static int[] reArrangeElements(int[] a) {
        int posIdx = 0;
        int negIdx = 1;
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            if (a[i] >= 0) {
                temp[posIdx] = a[i];
                posIdx = posIdx + 2;
            } else {
                temp[negIdx] = a[i];
                negIdx = negIdx + 2;
            }
        }
        return temp;
    }

    /*TODO: Next Permutation*/

    public static List<Integer> nextGreaterPermutation(List<Integer> a) {
        // [1,2,3] -> [3,2,1] -> [2,1,3]


        return a;
    }

    /*TODO Find Longest Consecutive sequence*/
    public static int longestConsecutiveSequenceBF(int[] arr) {
        int maxLength = 1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int cnt = 1;
            while (linearSearch(arr, x + 1) == true) {
                x += 1;
                cnt++;
            }
            maxLength = Math.max(maxLength, cnt);
        }
        return maxLength;
    }

    /* TODO : Linear Search*/

    public static boolean linearSearch(int[] a, int element) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                return true;
            }
        }
        return false;
    }

    /*TODO now using hashing :-*/

    public static int longestConsecutive(int[] a) {
        int n = a.length;
        if (n == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int x = num;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }



}
