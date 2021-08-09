public class Solution_152 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }

    public static int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int max=1, min = 1, result = 0, tempMax=0;
        for(int i=0; i<nums.length;i++){
            tempMax= Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(max*nums[i],min*nums[i]),nums[i]);
            max = tempMax;
            result = Math.max(max,result);
        }
        return result;
    }
}
