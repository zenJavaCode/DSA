package streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {

    /*TODO :- what if i need to print duplicate characters*/
    public static void main(String[] args) {
        String input = "Hello world Hello Java Java Hello";
        String[] words = input.split("\\s+");
        Map<String,Long> wordMap = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordMap.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println("Word " +entry.getKey()+ " value "+entry.getValue()));
        String inputs = "Hello world Hello Java Java Hello";
               String ip = "hello world";
        // Convert the input string to a character array
        char[] characters = ip.replaceAll("\\s", "").toCharArray();
        int[] intChars = new int[characters.length];
        for (int i = 0; i < characters.length; i++) {
            intChars[i] = characters[i];
        }
        // Count the occurrences of each character using streams
        Map<Character, Long> charCount = java.util.Arrays.stream(intChars).mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the duplicate characters
        charCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue()));

        /*TODO Write a Java 8 program to find only duplicate elements with its count from the String ArrayList ? InputArr=["AB", "BB", "AA", "AB", "ABC"]*/

        String[] arr = {"AB", "BB", "AA", "AB", "ABC"};
        Map<String,Long> stringMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        stringMap.entrySet().stream().filter(entry -> entry.getValue()>1).forEach(entry -> System.out.println("Word :"+ entry.getKey() + " Value "+entry.getValue()));

        
    }
}
