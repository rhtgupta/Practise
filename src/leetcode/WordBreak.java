package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        if (wordBreak("ilikesamsung"))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
        if (wordBreak("iiiiiiii"))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
        if (wordBreak(""))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
        if (wordBreak("ilikelikeimangoiii"))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
        if (wordBreak("samsungandmango"))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
        if (wordBreak("samsungandmangok"))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
    }


    static boolean dictionaryContains(String word) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "like", "ice", "cream"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++)
            if (dictionary[i].compareTo(word) == 0)
                return true;
        return false;
    }

/*    static boolean dictionaryContainsUsingSet(String word) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "like", "ice", "cream"};
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        return set.contains(word);
    }*/

    static boolean wordBreak(String str) {
        int size = str.length();
        if (size == 0) {
            return true;
        }

        boolean[] wb = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substring(0, i)"
            if (wb[i] == false && dictionaryContains(str.substring(0, i)))
                wb[i] = true;

            // wb[i] is true, then check for all subStrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true) {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // subString starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dictionaryContains(str.substring(i, j)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"
     for (int i = 1; i <= size; i++)
        System.out.print(" " +  wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }
}
