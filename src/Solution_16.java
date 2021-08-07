import java.util.Arrays;

public class Solution_16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,1,2} , 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int left, right, curSum;
        int result = target>0?Integer.MAX_VALUE/2-1:Integer.MIN_VALUE/2+1;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            left = i+1;
            right = nums.length-1;
            while(left<right){
                curSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-result) > Math.abs(target - curSum)) result = curSum;

                if(curSum == target) return curSum;
                else if(curSum < target) left++;
                else right--;
            }
        }
        return result;

    }
}
