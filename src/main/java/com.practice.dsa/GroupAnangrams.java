package src.main.java.com.practice.dsa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnangrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        result.stream().forEach(e -> System.out.print(e));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for(int i =0; i< strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String n = new String(ch);
            if(map.containsKey(n)){
                List<String> subSet = map.get(n);
                subSet.add(strs[i]);
                map.put(n,subSet);
            }else{
                List<String> newData = new ArrayList<>();
                newData.add(strs[i]);
                map.put(n,newData);
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
