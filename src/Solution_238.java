public class Solution_238 {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1,2,3,4});
        for(int i:result){
            System.out.print(i+", ");
        }
    }

//    private static int[] productExceptSelf(int[] nums) {
//        int[] ascending = new int[nums.length];
//        int[] descending = new int[nums.length];
//        int[] result = new int[nums.length];
//        ascending[0] = nums[0];
//        descending[nums.length-1] = nums[nums.length-1];
//        for (int i=1;i<nums.length;i++){
//            ascending[i] = ascending[i-1]*nums[i];
//        }
//        for (int j=nums.length-2; j>=0; j--){
//            descending[j] = descending[j+1]*nums[j];
//        }
//        for (int k=1; k<nums.length-1; k++){
//            result[k] = ascending[k-1] * descending[k+1];
//        }
//        result[0] = descending[1];
//        result[nums.length-1] = ascending[nums.length-2];
//        return result;
//    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            result[i] = result[i-1]*nums[i];
        }
        int rightProduct = 1;
        for (int j=nums.length-1; j>0; j--){
            result[j] = result[j-1]*rightProduct;
            rightProduct*=nums[j];
        }
        result[0] = rightProduct;
        return result;
    }
}

