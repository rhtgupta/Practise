package graph_revision_final;

import java.util.*;

public class Test {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new TreeMap<>();
        for(String str : strs){
            int value = 0;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                value = value + (c - 'a');
            }
            if(map.get(value) == null){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(value, list);
            }else{
                List<String> list = map.get(value);
                list.add(str);
                map.put(value, list);
            }
        }
        List<List<String>> result = new LinkedList<>();

        for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
        String []array = {"ac", "c"};
//        test.groupAnagrams(array);
        char c = 'c';
        System.out.println('l' - 0);
    }
}
