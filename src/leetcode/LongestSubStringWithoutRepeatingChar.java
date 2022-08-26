package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "au";
        System.out.println(findLongestSubstring(s));
    }

    static int findLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int startIndex = 0;
        int endIndex = 0;
        int lengthLongestSubString = Integer.MIN_VALUE;

        while (endIndex < s.length()) {
            char c = s.charAt(endIndex);
            while (!set.add(c)) {
                set.remove(s.charAt(startIndex));
                startIndex++;
            }
            lengthLongestSubString = Math.max(lengthLongestSubString, set.size());
            endIndex++;
        }
        return lengthLongestSubString == Integer.MIN_VALUE ? 0 : lengthLongestSubString;
    }
}
