package functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        Consumer<String> s = message -> System.out.println(message);
        s.accept("Piyush is Learning");
        Supplier<Double> supplier = () -> Math.random();
        double randomNumber = supplier.get();
        System.out.println("the random number is "+randomNumber);

        Predicate<Integer> isEven = num -> num%2 ==0;
        System.out.println(isEven.test(23));

        Function<Integer,Double> half = a -> a/2.0;
        half = half.andThen(a -> 3 * a );
        System.out.println(half.apply(24));
    }
}
