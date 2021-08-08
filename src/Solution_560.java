public class Solution_560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{2,4,6,7,3,6,2},10));
    }

    public static int subarraySum(int[] nums, int k) {

        //@TODO coding the better solution

        int count = 0;
        int[] sum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            sum[i+1] = sum[i] + nums[i];
            if(sum[i+1]==k) count++;
        }
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+2; j<nums.length+1; j++){
                sum[j] -= nums[i];
                if(sum[j] == k) count++;
            }
        }
        return count;
    }
}
