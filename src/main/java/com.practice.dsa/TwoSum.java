package src.main.java.com.practice.dsa;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    public static void main(String[] args) {

        //int[] input = new int[]{2,7,11,15}; //target 9
        //int[] input = new int[]{3,2,4};//target 6
            int[] input = new int[]{-18,12,3,0};
       // int[] result = twoSum(input,-6);
       // int[] result = twoSum2(input,-6);
        int[] result = twoSum3(input,-6);
        for(int i : result){
            System.out.print(i+" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int sum = 0;

        for(int i=0;i< nums.length;i++){
            sum = nums[i];
            for(int j = i+1; j< nums.length;j++){
                sum += nums[j];
                if(sum != target) sum -= nums[j];
                else if( sum == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static int[] twoSum2(int[] nums, int target) {

        for(int i=0;i< nums.length;i++){
            for(int j = i+1; j< nums.length;j++){
                if(nums[i] + nums[j] == target) {
                   return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> complements = new HashMap<>();
        for(int i=0;i< nums.length;i++){
           complements.put(nums[i],i);
           int comp = target- nums[i];
           if(complements.containsKey(comp)){
               return new int[]{i,complements.get(comp)};
               }
        }
        return new int[]{-1,-1};
    }
}
