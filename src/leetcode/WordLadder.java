package leetcode;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 1;

        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < current.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] array = current.toCharArray();
                        array[j] = (char) k;
                        String newCurrent = new String(array);
                        if (set.contains(newCurrent) && !visited.contains(newCurrent)) {
                            visited.add(newCurrent);
                            queue.add(newCurrent);
                        }
                    }
                }
            }
            step++;
        }
        return 0;

    }

}
