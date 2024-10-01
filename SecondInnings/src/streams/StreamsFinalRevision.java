package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsFinalRevision  {

    public static void main(String[] args) {
        System.out.println("Stream without terminal operation");

//        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
//            System.out.println("doubling " + i);
//            return i * 2;
//        });

        Arrays.stream(new int[] {1,2,3}).map(i ->  {
            System.out.println("Without terminal operation");
            return i*2;
        });


        Arrays.stream(new int[] {1,2,3}).map(i -> i*2).forEach(System.out::println);


        System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        }).sum();



        Stream<String> stream
                = Stream.of("Geek_First", "Geek_2",
                "Geek_3", "Geek_4",
                "Geek_Last");

        String first_element
                = stream

                // reduce() method reduces the Stream
                // to a single element, which is first.
                .reduce((first, second) -> first)

                // if stream is empty
                // null is returned
                .orElse(null);


// TODO Find Dulplicate now

        int[] arr = {5, 13, 4, 21, 13, 27, 2, 59, 59, 34};

      //  Map<Integer,Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

    // USING SET.
        Set<Integer> items = new HashSet<>();
        Set<Integer> duplicates  =  Arrays.stream(arr).boxed().filter(n -> !items.add(n)).collect(Collectors.toSet());

        // USING Collections.FREQUENCY
        List<Integer> list = Arrays.stream(arr).boxed().toList();
       List<Integer> duplicateList = list.stream().filter(i -> Collections.frequency(list,i)>1).collect(Collectors.toUnmodifiableList());


       

    }
}
