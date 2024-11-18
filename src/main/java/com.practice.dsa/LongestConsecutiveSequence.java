package src.main.java.com.practice.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = new int[] {100, 4, 200, 1, 3, 2};
        //longestConsecutive(nums);
        System.out.println(longestConsecutiveBigOn(nums2));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        int maxCount = Integer.MIN_VALUE;
        for(int i =0;i< nums.length-1;i++){
            if(nums[i] +1 == nums[i+1]){
                count++;
            }else{
                maxCount = Math.max(count,maxCount);
            }
        }
        maxCount= Math.max(count,maxCount);
        System.out.println(maxCount+1);
        return maxCount+1;
    }


    //0,3,7,2,5,8,4,6,1
    public static int longestConsecutiveBigOn(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxStreak = Integer.MIN_VALUE;
        for(int i:nums){
            set.add(i);
        }

        for(int i : set) {

            if (!set.contains(i - 1)) {
                int currentNum = i;
                int currentStreak = 1;

                while (set.contains(i + 1)) {
                    currentStreak++;
                    i = i + 1;
                }
                maxStreak = Math.max(currentStreak, maxStreak);
            }
        }
        return maxStreak;
    }
}
