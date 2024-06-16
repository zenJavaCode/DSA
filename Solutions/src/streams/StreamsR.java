package streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamsR {

    public static void main(String[] args) {
       String in = "INDIA";
        String[] input = {"AB", "PH", "AB", "RS", "QT"};

        Map<String, Long> maps = Arrays.stream(input)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        System.out.println(maps);
        Map<Character,Long> map = in.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Character c =  map.entrySet().stream().filter(entry -> entry.getValue() ==1L).map(Map.Entry::getKey).findFirst().orElse(null);

        Character p = map.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(Map.Entry::getKey).skip(1).findFirst().orElse(null);

    }
}
