package src.main.java.com.practice.dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] result = topKFrequent(nums,2);
        for(int i : result){
            System.out.println(i+" ");
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> mappingInt = new HashMap<>();
        for(int i: nums){
            mappingInt.put(i, mappingInt.getOrDefault(i,0)+1);
        }


        LinkedHashMap<Integer,Integer> resMap= mappingInt.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue)-> oldValue, LinkedHashMap::new));

        int[] result = new int[k];
        int i =0;
        for(Map.Entry<Integer,Integer> entry: resMap.entrySet()){
            result[i] = entry.getKey();
            i++;
        }
        return result;
    }
}
