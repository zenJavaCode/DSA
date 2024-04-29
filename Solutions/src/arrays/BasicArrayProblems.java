package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class BasicArrayProblems {

    public static int[] mergeTwoArrayUsingHashSet(int[] a , int[] b){
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


    public static List<Integer> mergeTwoArrayUsingLinkedList(int[] a , int[] b){

        List<Integer> list = new ArrayList<>();
        for(int num :a){
            list.add(num);
        }
        for(int num :b){
            list.add(num);
        }
       List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        return sortedList;
    }


    /*TODO: Take two pointers let’s say i,j pointing to the 0th index of arr1 and arr2.
    *  Create an empty vector for storing the union of arr1 and arr2.
    *  From solution 2 we know that the union is nothing but the distinct elements in arr1 + arr2
    *  arr1[ i ] == arr2[ j ]
        Here we found a common element, so insert only one element in the union. Let’s insert arr[i] in union and increment i.

*/

    public static List<Integer> mergeTwoArrayUsingTwoPointer(int[] a , int[] b){
int i = 0, j = 0;
List<Integer> Union = new ArrayList<>();
int n = a.length;
int m = b.length;
        while (i < n && j < m) {
            if (a[i] <= b[j]){
                if (Union.size() == 0 || Union.get(Union.size()-1) != a[i])
                Union.add(a[i]);
                i++;
            }
            else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != b[j])
                    Union.add(b[j]);
                j++;
            }
        }while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size()-1) != a[i])
                Union.add(a[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size()-1) != b[j])
                Union.add(b[j]);
            j++;
        }
        return Union;
    }

    ///*TODO find second highest and second lowest*/

    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        if (n == 0 || n==1)
        {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE ;
        int i;
        for (i = 0;i < n;i++)
        {
            small = Math.min(small,a[i]);
            large = Math.max(large,a[i]);
        }
        for (i = 0;i < n;i++)
        {
            if (a[i] < second_small && a[i] != small)
            {
                second_small = a[i];
            }
            if (a[i] > second_large && a[i] != large)
            {
                second_large = a[i];
            }
        }


        return new int[] {second_large,second_small};

    }
// TODO : is Array Sorted?
    public static int isSorted(int n, int []a) {
        // Write your code here.
        for(int i =1 ;i<a.length;i++){
            if(a[i]<a[i-1]){
                return 0;
            }
        }
        return 1;
    }

    /*TODO: remove duplicate */
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int count = 0;
        for(int i =0;i<n-1;i++){
            if(arr[i] == arr[i+1]){
                count++;
            }
        }
        return n-count;
    }


    /*TODO ; Left rotate by 1 place*/

    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.
        int temp = arr[0];
        for(int i =1 ; i<n;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    /*TODO Left rotate by D place*/

    static int[] rotateArrayByDPlace(int[] arr ,int d){

        int[] temp = new int[arr.length];
        int counter =0;
        for(int i =d ;i<arr.length;i++){
            temp[counter] = arr[i];
            counter++;
        }
        for(int i=0;i<d;i++){
            temp[counter] = arr[i];
            counter++;
        }
        return temp;
    }

    /*TODO Given an array 'arr' of 'n' non-negative integers, your task is to move all
       the zeros to the end of the array while keeping the non-zero elements at the start
       of the array in their original order. Return the modified array.

     */
        public static int[] moveZerosToEnd(int[] arr, int n) {

            int count =0;
            for(int i=0;i<n;i++){
                if(arr[i] !=0){
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                    count++;
                }
            }
return arr;
        }

        /*TODO You are given an array ‘arr’ containing ‘n’ integers. You are also given an integer ‘num’,
           and your task is to find whether ‘num’ is present in the array or not.
                If ‘num’ is present in the array, return the 0-based index of the first occurrence
                 of ‘num’. Else, return -1.*/

    public static int linearSearch(int n, int num, int []arr){
        // Write your code here.
        for(int i =0;i<n;i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;

    }

    /*TODO Find Missing number */

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i =0;
        for(i =0;i<nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return i;
    }

    /*TODO Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.*/

    public static int countConsecutiveOne(int[] a,int n ){
        int count = 0;
        int maxCount = 0;
        for(int i =0;i<n;i++){
            if(a[i] ==1){
                count++;
                maxCount = Math.max(maxCount,count);
            }else{
                count =0;
            }
        }
        return maxCount;
    }

    /*TODO You are given a sorted array 'arr' of positive integers of size 'n'.
        It contains each number exactly twice except for one number, which occurs exactly once.
        Find the number that occurs exactly once.*/

    public static int getSingleElement(int []arr){
        // Write your code here.
        for(int i =0;i<arr.length-1; i =i+2){
            if(arr[i] !=arr[i+1]){
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }


    /*TODO You are given an array 'a' of size 'n' and an integer 'k'.
           Find the length of the longest subarray of 'a' whose sum is equal to 'k'.*/






}
