package src.main.java.com.practice.dsa;

public class TwoSum_SortedArray {

    public static void main(String[] args) {
        int[] numbers = new int[] {2,3,4};
        int[] result = twoSum(numbers,6);
        for(int i : result){
            System.out.print(" "+i);
        }

    }

//use only constant extra space
    public static int[] twoSum(int[] numbers, int target) {

        int startIndex = 0;
        int endIndex = numbers.length-1;
        while(startIndex<endIndex){
            int sum = numbers[startIndex]+numbers[endIndex];
            if (sum == target) return new int[] {startIndex+1,endIndex+1};
            else if (sum > target) endIndex--;
            else startIndex++;
        }

        return new int[2];
    }
}
