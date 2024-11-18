package src.main.java.com.practice.dsa;

public class ProductOfArrayExceptItself {

    public static void main(String[] args) {

        int[] nums = new int[]{-1,1,0,-3,3};
        //  int[] result = productExceptSelf(nums);
        int[] result = twoWayProduct(nums);

        for(int i : result){
            System.out.println(i+",");
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean isZeroPresent = false;
        for(int i =0;i< nums.length;i++){
            if(nums[i] != 0 ){
                product *= nums[i];
            } else if(isZeroPresent && nums[i] == 0){
                product =0;
            }else if (nums[i] == 0){
                isZeroPresent = true;
            }
        }

        int[] result = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            if(nums[i] == 0) result[i] = product;
            else if (isZeroPresent) result[i] = 0;
            else result[i] = product/nums[i];

        }

        return result;
    }

    public static int[] twoWayProduct(int[] nums){
        int[] output = new int[nums.length];
        int leftProduct = 1;
        int rightProduct =1;

        for(int i=0;i< nums.length;i++){
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int j= nums.length-1;j>=0;j--){
            output[j] *= rightProduct;
            rightProduct *= nums[j];
        }

        return output;
    }
}
