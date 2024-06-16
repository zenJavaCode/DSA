package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    /*TODO :- what if i need to print duplicate characters*/
//    public static void main(String[] args) {
//        String input = "Hello world Hello Java Java Hello";
//        String[] words = input.split("\\s+");
//        Map<String,Long> wordMap = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        wordMap.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println("Word " +entry.getKey()+ " value "+entry.getValue()));
//        String inputs = "Hello world Hello Java Java Hello";
//               String ip = "hello world";
//        // Convert the input string to a character array
//        char[] characters = ip.replaceAll("\\s", "").toCharArray();
//        int[] intChars = new int[characters.length];
//        for (int i = 0; i < characters.length; i++) {
//            intChars[i] = characters[i];
//        }
//        // Count the occurrences of each character using streams
//        Map<Character, Long> charCount = java.util.Arrays.stream(intChars).mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        // Print the duplicate characters
//        charCount.entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .forEach(entry -> System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue()));
//
//        /*TODO Write a Java 8 program to find only duplicate elements with its count from the String ArrayList ? InputArr=["AB", "BB", "AA", "AB", "ABC"]*/
//
//        String[] arr = {"AB", "BB", "AA", "AB", "ABC"};
//        Map<String,Long> stringMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        stringMap.entrySet().stream().filter(entry -> entry.getValue()>1).forEach(entry -> System.out.println("Word :"+ entry.getKey() + " Value "+entry.getValue()));
//
//
//    }

//    public static void main(String[] args) {
//        System.out.println("=================================");
//        System.out.println("Using Sequential Stream");
//        System.out.println("=================================");
//        int[] array= {1,2,3,4,5,6,7,8,9,10};
//        IntStream intArrStream=Arrays.stream(array);
//        intArrStream.forEach(s->
//                {
//                    System.out.println(s+" "+Thread.currentThread().getName());
//                }
//        );
//        System.out.println("=================================");
//        System.out.println("Using Parallel Stream");
//        System.out.println("=================================");
//        IntStream intParallelStream=Arrays.stream(array).parallel();
//        intParallelStream.forEach(s->
//                {
//                    System.out.println(s+" "+Thread.currentThread().getName());
//                }
//        );
//    }


    public static void main(String[] args) {

        long currentTime=System.currentTimeMillis();
        List<Integer> data=new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            data.add(i);
        }

        long sum=data.parallelStream()
                .map(i ->(int)Math.sqrt(i))
                .map(number->performComputation(number))
                .reduce(0,Integer::sum);

        System.out.println(sum);
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken to complete:"+(endTime-currentTime)/(1000*60)+" minutes");

    }

    public static int performComputation(int number)
    {
        int sum=0;
        for (int i = 1; i < 1000000; i++) {
            int div=(number/i);
            sum+=div;

        }
        return sum;
    }
}
