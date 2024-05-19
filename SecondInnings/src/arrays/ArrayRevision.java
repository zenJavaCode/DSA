package arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayRevision {


    /*TODO longestSubarrayWithSum*/
    public int longestSubarrayWithSum(int[] arr, int target) {
        int maxLength = 0;
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (runningSum == target) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int rem = runningSum - target;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLength = Math.max(maxLength, len);
            }
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, i);
            }
        }
        return maxLength;
    }
}
