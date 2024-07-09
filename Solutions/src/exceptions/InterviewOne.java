package exceptions;

public class InterviewOne {

    /*TODO :Given a sorted array of distinct integers and a target value, return the index if the target is found.
            If not, return the index where it would be inserted in order.
              e.g:
            findTarget({1, 2, 3, 4, 5}, 2) ->  1
            Constraints: You must write an algorithm with O(log n) runtime complexity.*/

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 2;
        System.out.println( binarySearch(arr,target));

    }

    public static int binarySearch(int[] arr, int target){
        int low =0;
        int high = arr.length;
        int indexCounter =0;
        while(low<high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]>target){
                high = mid;
                high--;
                indexCounter = Math.min(indexCounter,mid);
            }else{
                indexCounter  = Math.max(indexCounter,mid);
                
                low++;
            }
        }
            return indexCounter +1;

    }
}
