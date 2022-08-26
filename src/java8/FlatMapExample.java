package java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Rohit", "Gupta"));
        System.out.println(list.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
    }

}
