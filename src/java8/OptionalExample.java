package java8;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> optionalString = Optional.ofNullable("I am value");

        // ifPresent()
        if (optionalString.isPresent()) {
            System.out.println(optionalString);
        } else {
            System.out.println("I am null");
        }

        // ifPresent
        optionalString.ifPresent(value -> {
            System.out.println(value);
        });

        // ifPresentOrElse
        optionalString.ifPresentOrElse(value -> System.out.println(value), () -> {
            System.out.println("I am null");
        });

        // orElse
        System.out.println(optionalString.orElse("I am null"));

        // orElseGet
        System.out.println(optionalString.orElseGet(() -> {
            return "I am null";
        }));
    }

}
