package arrays;

import java.util.Arrays;

public class Sample {

    public static void main(String[] args) {

        /*TODO :- Can you print the sum of the first max and second max element in a given array ?*/

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int sum = Arrays.stream(arr).boxed().sorted((a,b) ->  b-a).mapToInt(Integer::intValue).limit(2).sum();
        System.out.println(sum);

    }
}
