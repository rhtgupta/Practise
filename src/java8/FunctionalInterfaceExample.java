package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // Predicate
        Predicate<Integer> predicate = value -> {
            return (value % 2 == 0) ? true : false;
        };
        System.out.println(predicate.test(18));

        // Function
        Function<String, Integer> function = value -> {
            return value.length();
        };
        System.out.println(function.apply("AAAAAAAAAAAAAA"));

        // Consumer
        Consumer<String> consumer = value -> System.out.println(value);
        consumer.accept("Rohit");

        // Supplier
        Supplier<String> supplier = () -> {
            return "I am supplier";
        };
        System.out.println(supplier.get());
    }
}
