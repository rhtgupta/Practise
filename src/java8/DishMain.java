package java8;

import jdk.swing.interop.SwingInterOpUtils;
import revision.CountDownLatchES;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishMain {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    ;


    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        // find the highest-calorie dish in the menu.
        Comparator<Dish> comparator = (dish1, dish2) -> {
            return dish2.getCalories() - dish1.getCalories();
        };
        menu.stream().sorted(comparator).limit(1).forEach((dish) -> System.out.println(dish));
        System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))).orElse(null));

        // total number of calories in your menu list
        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
        System.out.println(menu.stream().map(Dish::getCalories).reduce(0, (cal1, cal2) -> {
            return cal1 + cal2;
        }));

        // concatenate the names of all the dishes in the menu
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(" ,")));

        //sort dishes based on calories
        System.out.println(menu.stream().sorted(Comparator.comparing(Dish::getCalories)).collect(Collectors.toList()));

        // groupingBy
        System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType)));

        // partitioningBY
        System.out.println(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian)));



















        /*
        // find the highest-calorie dish in the menu.
        System.out.println(menu.stream().reduce((dish1, dish2) -> {
            return dish1.getCalories() < dish2.getCalories() ? dish2 : dish1;
        }).orElseThrow());

        System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))));

        // total number of calories in your menu list
        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
        System.out.println(menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum)));

        // concatenate the names of all the dishes in the menu
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(", ")));

        //
        System.out.println(menu.stream().collect(Collectors.groupingBy(Dish::getType)));

        System.out.println(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian)));*/

    }
}
