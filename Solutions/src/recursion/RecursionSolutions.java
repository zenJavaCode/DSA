package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

@author: Piyush Jain*/
public class RecursionSolutions {

    public static void main(String[] args) {
      int[] num =  printNos(10);
        System.out.println(Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.toList()));
    }

/*TODO: You are given an integer ‘n’.
        Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.*/

    public static int[] generateArray(int n){
        if(n<=0){
            return  new int[0];
        }
        int[] result = generateArray(n - 1);
        int[] newArray = new int[result.length + 1];
        System.arraycopy(result,0, newArray,0,result.length);
        newArray[result.length]= n;
        return newArray;
    }

    /*TODO  Print N Times DSA is easy*/

    public static List<String> printNtimes(int n){

        List<String> str =  new ArrayList<>();
        recursion(n, str);
        return str;

    }

    public static void recursion(int n, List<String> str){
        if(n==0){
            return;
        }
        str.add("DSA is easy. ");
        recursion(n-1, str);
    }


    /*TODO Print 1 to N using recursion*/

    public static int[] OneTON(int n ){
        if(n ==0){
            return new int[0];
        }
        int[] result = new int[n];
        result[n-1] = n;
        System.arraycopy(OneTON(n - 1), 0, result, 0, n - 1); // Alternative: Use Arrays.copyOf
        return result;
    }

    /*TODO: PRINT N TO 1 */
    public static int[] printNos(int x) {
        int[] ans=new int[x];
        recursive(0, x, ans ,1);
        return ans;
    }



    public static void recursive(int i,int x,int[] num,int target){
        if(x==target){
            num[i] = target;
            return;
        }
        else{
            num[i]=target;
            recursive(i+1,x ,num,target+1);
        }
    }

    /*TODO Sum of n natural numbers using recursion*/

    public static long sumOfNaturalNumbers(long n){
        if(n ==1){
            return n;
        }else{
            return n + sumOfNaturalNumbers(n-1);
        }
    }

    /*TODO : Factorial of a number*/

    public static int factorialNumber(int n){

        if(n ==1 || n ==0) {
            return 1;
        }else{
            return n* factorialNumber(n-1);
        }
    }


    /*TODO Reverse an Array */

    public static int[] reverseArray(int n, int []nums) {
        // Write your code here.
        int[] reversedArray = new int[n];
        int index = nums.length-1;
        reversedArray =   reversedArrayFunction(reversedArray, index, nums,0);
        return reversedArray;
    }

    public static int[] reversedArrayFunction(int[] reversedArray,int index,int[] nums,int i  ){

        if(i == nums.length-1){
            reversedArray[i] = nums[index];
            return reversedArray;
        }
        else{
            reversedArray[i] = nums[index];
            return reversedArrayFunction(reversedArray, index-1, nums,i+1);
        }
    }

    /*TODO Check palindrome in string*/

    public static boolean isPalindrome(String str) {
        // Write your code here.
        char[] chr = str.toCharArray();
        StringBuilder reverseStr = new StringBuilder();
        for(int i =chr.length-1;i>=0;i--) reverseStr.append(chr[i]);

        return str.equals(reverseStr.toString());

    }

    /* TODO Check palindrome in string using recursion */

    public static Boolean  isStringPalindrome(StringBuilder reversedString,char[] chr,int n){
        if(n ==0){
            reversedString.append(chr[0]);
            String originalStr = new String(chr);
            return originalStr.equals(reversedString.toString()) ;
        }else{
            return isStringPalindrome(reversedString,chr,n-1);
        }

    }


    /*TODO FIBONACCI SERIES*/
    public static int[] generateFibonacciNumbers(int n) {
        // Write your code here.

        if (n <= 0) {
            return new int[0]; // Return an empty array for invalid input
        } else if (n == 1) {
            return new int[]{0}; // Return [0] for n = 1
        } else if (n == 2) {
            return new int[]{0, 1}; // Return [0, 1] for n = 2
        }
      int arr[] = new int[n];
        arr[0] =0;
        arr[1] = 1;
        int index =1;
        arr = recursiveFibonacci( arr, index+1);
        return arr;

    }

    private static int[] recursiveFibonacci(int[] arr, int index) {
        if(index == arr.length){
            return arr;
        }
        arr[index] = arr[index-1] + arr[index-2];
        return arr;
    }


}
