package sorting;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           int minIndex = i;
           for (int j = i + 1; j < arr.length; j++) {
               if(arr[j] < arr[minIndex]) {
                   minIndex = j;
               }
           }
           if(minIndex != i) {
               int temp = arr[minIndex];
               arr[minIndex] = arr[i];
               arr[i] = temp;
           }
        }


    }
}
