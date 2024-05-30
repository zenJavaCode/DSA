package designPatterns.factory.TaxCalculation;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LntInterview {

    public static void main(String[] args) {
        String s = "PiyushJain";

        // count of each charactor

        Map<Character,Long> map = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String s1 = new String("Piyush Jain");
        String s2 = new String("Piyush Jain");

        //

        System.out.println(map);

    }


}
