package src.main.java.com.practice.dsa;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {

        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{-2,0,1,1,2};
        List<List<Integer>> result = threeSumO(nums);
        for(List<Integer> list : result){
            list.stream().forEach(i -> System.out.print(i+","));
            System.out.println();
        }

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int sum =0;
        int leftIndex = 0;

        Arrays.sort(nums);

        Map<Integer,List<Integer>> indexDataMap = new LinkedHashMap<>();
        for(int num: nums){
            indexDataMap.computeIfAbsent(num,key-> new ArrayList<>()).add(i);
            i++;
        }

        while(leftIndex < nums.length-2 ) {
            int middleIndex = leftIndex + 1;
            while (middleIndex < nums.length-1) {

                int target = nums[leftIndex] + nums[middleIndex];
                int target2 = 0 - target;
                    if (indexDataMap.containsKey(target2)) {
                        List<Integer> indexes = indexDataMap.get(target2);
                        int finalLeftIndex = leftIndex;
                        int finalMiddleIndex = middleIndex;
                        Optional<Integer> rightIndex = indexes.stream().filter(index -> index != finalLeftIndex && index != finalMiddleIndex).findFirst();
                        List<Integer> subList = Arrays.asList(nums[leftIndex], nums[middleIndex], nums[rightIndex.get()]).stream()
                                .collect(Collectors.toList());

                        if (!result.contains(subList)) {
                            result.add(subList);}
                    }
                middleIndex++;
            }
            leftIndex++;
        }
        return result;

    }

    //// -2,0,1,1,2
    public static List<List<Integer>> threeSumO(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int sum =0;
        int leftIndex = 0;

        Arrays.sort(nums);

        while(leftIndex < nums.length-2 ) {
            int middleIndex = leftIndex + 1;
            while (middleIndex < nums.length-1) {
                int rightIndex = middleIndex + 1;
                int target = nums[leftIndex] + nums[middleIndex];
                while (rightIndex < nums.length) {
                    int target2 = target+ nums[rightIndex];
                    if (target2== 0) {
                        List<Integer> subList = Arrays.asList(nums[leftIndex], nums[middleIndex], nums[rightIndex]);
                        subList.sort(null);
                        if (!result.contains(subList)) {
                            result.add(subList);
                        }
                        rightIndex++;
                    } else if (target2 > 0) {
                        break;
                    } else {
                        rightIndex++;
                    }
                }
                middleIndex++;
            }
            leftIndex++;
        }
        return result;
    }
}
