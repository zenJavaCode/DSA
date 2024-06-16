package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRevision {


    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5,6,7};
        int[] temp = rightRotateByD(nums,3);
    }

    public static int reverse(int x) {

        int temp = x;
        int rev = 0;
        while(temp !=0){
            int ld = temp %10;
            rev = (rev * 10)+ld;
            temp /=10;
        }
       return rev;


    }


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

    /*TODO Merge Two array using hashset*/


    public static int[] mergeTwoArrayUsingHashSet(int[] a,int[] b){
        Set<Integer> set = new HashSet<>();
        for(int num :a){
            set.add(num);
        }
        for(int num :b){
            set.add(num);
        }
        int[] res = new int[a.length+ b.length];
        int counter =0;
        for(Integer num :set){
            res[counter] = num;
            counter++;
        }
        return res;
    }

    /*TODO  Merge Two Array using Arraylist*/
    public static List<Integer> mergeingArrays(int[] a, int[] b){

        List<Integer> result = new ArrayList<>();

        for(int num :a){
            result.add(num);
        }
        for(int num :b){
            result.add(num);
        }
        List<Integer> sortedList = result.stream().sorted().collect(Collectors.toList());
        return sortedList;

    }

    /*TODO Merge Two Array using Pointers*/

    public static List<Integer> sortedList(int[] a,int[] b){
        List<Integer> sortedList = new ArrayList<>();
        int i=0 ,j =0;
        int n = a.length;
        int m = b.length;
        while(i<n && j<m){
            if(a[i]<= b[i]){
                sortedList.add(a[i]);
                i++;
            }else{
                sortedList.add(b[j]);
                j++;
            }
        }
        while(i<n){
            sortedList.add(a[i]);
            i++;
        }
        while(j<m){
            sortedList.add(a[j]);
            j++;
        }
        return sortedList;
    }

    /*TODO find Second Highest And Second Lowest*/

    public static int[] getSecondOrderElements(int[] a){
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for(int i =0;i<a.length;i++){
            if(a[i]>highest){
                secondHighest = highest;
                highest = a[i];
            } else if(a[i] !=highest && a[i] > secondHighest){
                secondHighest = a[i];
            }
            if(a[i]<lowest){
                secondLowest = lowest;
                lowest = a[i];
            }else if(a[i] !=lowest && a[i] < secondLowest ){
                secondLowest = a[i];
            }

        }
        int[] result = new int[]{secondHighest,secondLowest};
        return result;
    }

    /*TODO Left Rotate By d places*/


    public static int[] leftRotateByD(int[] arr,int d){

        int counter =0;
        int[] temp = new int[arr.length];
        for(int i =d;i<arr.length;i++){
            temp[counter] = arr[i];
            counter++;
        }
        for(int i =0;i<d;i++){
            temp[counter] = arr[i];
        }
        return temp;

    }

    /*TODO Right Rotate By D*/

    public static int[] rightRotateByD(int[] arr,int d){

    int counter =0;
    int[] temp = new int[arr.length];
    int rotateIndex = arr.length-d;
        for(int i =rotateIndex;i<arr.length;i++){
            temp[counter] = arr[i];
            counter++;
        }
        for(int i =0;i<rotateIndex;i++){
            temp[counter] = arr[i];
            counter++;
        }
        return temp;
    }

    /*TODO Move Zeros to End*/
    public static int[] moveZerosToEnd(int[] arr,int n){

        int count =0;
        for(int i =0;i<n;i++){
            if(arr[i] !=0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        return arr;
    }

    /*TODO Move all values equal to K to the end of the Array*/

    public static int[] moveValuesToEnd(int[] arr, int K) {
        int writeIndex = 0;
        for(int i =0;i<arr.length;i++){

            if(arr[i]!=K){
                int temp = arr[i];
                arr[i] = arr[writeIndex];
                arr[writeIndex] = temp;
                writeIndex++;
            }
        }
        return arr;

    }

    /*TODO Segregate Even and Odd Numbers*/

    public static int[] separateEvenOdd(int[] arr){
        int writeIndex =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] % 2 ==0){
                int temp = arr[i];
                arr[i] = arr[writeIndex];
                arr[writeIndex] = temp;
                writeIndex++;
            }
        }
        return arr;
    }

    /*TODO Find Missing Number*/

    public static int findMissingElement(int[] nums ){

        int arraySum =0;
        int n = nums.length+1;
        int expectedSum = (n * n+1)/2;
        System.out.println("expected sum :"+expectedSum);
        for(int i =0;i<nums.length;i++){
            arraySum += nums[i];
        }
        return expectedSum -arraySum;


    }

    /*TODO Count Consecutive Ones*/
    public static int countConsecutiveOnes(int[] arr){
        int count =0;
        int maxLength =0;
        for(int num :arr){
            if(num == 1){
                count++;
                maxLength = Math.max(count,maxLength);
            }else{
                count =0;
            }

        }
return maxLength;
    }

    /*TODO Problem 1: Longest Subarray with Equal Number of 0s and 1s
           Given a binary array, find the length of the longest subarray that contains an equal number of 0s and 1s.*/

    public static void longestSubArrayWithEqual0And1s(int[] arr){

    }



    public  static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right)
        {
            char l = s.charAt(left), r = s.charAt(right);
            if(!Character.isLetterOrDigit(l))
                left++;
            else if(!Character.isLetterOrDigit(r))
                right--;
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;

    }

    public  static int removeDuplicates(int[] nums) {

        int count =0;

        for(int i =1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                count++;
            }
        }

        return nums.length-count ;

    }

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int missingNumber =0;
        for(int num : set){
            if(missingNumber == num){
                missingNumber++;
            }else{
                return missingNumber;
            }
        }
        return -1;
    }

}
