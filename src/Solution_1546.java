public class Solution_1546 {

    public static void main(String[] args) {
        System.out.println(copy(new int[]{-5,5,-4,5,4},5));
    }

    // @TODO 不会写，下次写
    public static int maxNonOverlapping(int[] nums, int target) {
        int[] count = new int[1];
        preFixSum(nums,0,nums.length-1,target,count,true);
        return count[0];
    }

    public static int preFixSum(int[] nums, int left, int right, int target, int[] count,boolean flag){
        int pointer = left, sum = 0;
        while(pointer<=right){
            sum+=nums[pointer];
            if(sum==target){
                if (flag) {
                    for(int i=left;i<=pointer;i++){
                        System.out.print(nums[i]+",");
                    }
                    System.out.println("");
                    int[] subCount = new int[1];
                    left = preFixSum(nums,left+1,pointer,target,subCount,true);
                    count[0] += Math.max(subCount[0], 1);
                    pointer=left+1;
                    break;
                } else {
                    int temp = preFixSum(nums,left+1,pointer,target,count,false);
                    return Math.min(temp,pointer);
                }
            }
            pointer++;
        }
        if(left>=right){
            return pointer;
        }
        preFixSum(nums,left+1,right,target,count,flag);
        return pointer;
    }

    public static int copy(int[] nums, int target){
        int N = nums.length;
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; ++i) {

            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + (sum == target ? 1 : 0));
            }
        }

        return dp[N];
    }

}
