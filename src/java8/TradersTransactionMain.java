package java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TradersTransactionMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Page 140 (Java8 in Action)

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println(transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));

        // 2. What are all the unique cities where the traders work?
        System.out.println(transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList()));

        // 3. Find all traders from Cambridge and sort them by name.
        System.out.println(transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()));

        // 4. Return a string of all traders’ names sorted alphabetically.
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.toList()));

        // 5. Are any traders based in Milan?
        System.out.println(transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

        // 6. Print all transactions’ values from the traders living in Cambridge.
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).forEach(value -> System.out.println(value));

        // 7. What’s the highest value of all the transactions?
        System.out.println(transactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue))).orElse(null));

        // 8. Find the transaction with the smallest value.
        System.out.println(transactions.stream().collect(Collectors.minBy(Comparator.comparing(Transaction::getValue))).orElseGet(() -> {return null;}));

/*
        //Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println(transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));

        //What are all the unique cities where the traders work?
        System.out.println(transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList()));

        //Find all traders from Cambridge and sort them by name.
        System.out.println(transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).sorted(Comparator.comparing(transaction -> transaction.getTrader().getName())).collect(Collectors.toList()));

        //Return a string of all traders’ names sorted alphabetically.
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().reduce((str1, str2) -> str1 + str2).orElse("No Trader name found"));

        //Are any traders based in Milan?
        System.out.println(transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

        //Print all transactions’ values from the traders living in Cambridge.
        System.out.println(transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).collect(Collectors.toList()));

        //What’s the highest value of all the transactions?
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).orElse(0));

        //Find the transaction with the smallest value.
        System.out.println(transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2).orElseThrow());
        System.out.println(transactions.stream().min(Comparator.comparing(Transaction::getValue)));*/

    }
}
