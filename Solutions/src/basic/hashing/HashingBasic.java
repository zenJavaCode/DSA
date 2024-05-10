package basic.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class HashingBasic {


    /*TODO Let’s first try to understand the importance of hashing using an example:
           Given an array of integers: [1, 2, 1, 3, 2] and we are given some queries: [1, 3, 4, 2, 10]. For each query,
            we need to find out how many times the number appears in the array. For example, if the query is 1
            our answer would be 2, and if the query is 4 the answer will be 0.
            Similarly, the following will be the answers to the given queries:

            Now, for each query, we will call the function and it will return the number of times the given query appears in the array.

Time Complexity analysis of the function:
We have learned how to compute the time complexity of any code. The above function contains a for loop that runs for N times. So, the time complexity of the function will be O(N) ignoring the other constant operations.

Now, for each query, we are calling this function. So, if the query contains 5 numbers and we call the function 5 times, the total time complexity will be O(5*N). If the number of queries is Q, the time complexity will be O(Q*N).

Now, if the length of the query becomes large like 105 and the array size also becomes large like 105, the time complexity will be O(1010).

 TODO:We know from our previous knowledge that 10^8 operations take 1 second to get executed.
  So, 10^10 operations will take around 100 seconds(10^10/10^8). We cannot say a code is good
  if it takes 100 seconds to get executed.



*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //precompute:
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer key = (Integer) arr[i];
            Integer freq = 0;
            if (mp.containsKey(key)) freq = mp.get(key); // fetching from the map
            freq++;
            mp.put(key, freq); // inserting into the map
        }

        // Iterate over the map:
        /*
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
        */
        int q;
        q = sc.nextInt();
        while (q-- > 0) {
            Integer number;
            number = (Integer) sc.nextInt();
            // fetch:
            if (mp.containsKey(number)) System.out.println(mp.get(number));
            else System.out.println(0);
        }
    }

    /*You are given an array 'arr' of length 'n' containing integers within the range '1' to 'x'.



Your task is to count the frequency of all elements from 1 to n.

Note:
You do not need to print anything. Return a frequency array as an array in the function such that index 0 represents the frequency of 1, index 1 represents the frequency of 2, and so on.
Example:
Input: ‘n’ = 6 ‘x’ = 9 ‘arr’ = [1, 3, 1, 9, 2, 7]
Output: [2, 1, 1, 0, 0, 0]*/


    public static int[] countFrequency(int n, int x, int[] nums) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer numI =nums[i];
            if (map.containsKey(Optional.of(nums[i]))) {
                map.put(Optional.of(nums[i]).get(), map.get(Optional.of(numI + 1)));
            } else {
                map.put(Optional.of(nums[i]).get(), 1);
            }

        }
        int maxKey = Integer.MIN_VALUE;
        int minKey = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey();
            if (freq > maxCount) {
                maxCount = freq;
                maxKey = entry.getKey();
            }
            if (freq < minCount) {
                minCount = freq;
                minKey = entry.getKey();
            }
            if (freq == minCount) {
                minKey = Math.min(key, minKey);
            }
            if (freq == maxCount) {
                maxKey = Math.min(key, maxKey);
            }
        }
        int arr[] = new int[2];
        arr[0] = maxKey;
        arr[1] = minKey;
        return arr;
    }


}
