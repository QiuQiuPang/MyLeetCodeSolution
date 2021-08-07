public class Solution_53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray( new int[]{5,4,-1,7,8}));
    }

    private static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int prevSign = (int) Math.signum(nums[0]);
        int[] newArray = new int[nums.length];
        int index = 0;

        for(int i:nums){
            int curSign = (int) Math.signum(i);
            if(curSign != prevSign) {
                index++;
                prevSign = curSign;
            }
                newArray[index] += i;
        }

        int[] finalArray = new int[index+1];
        for(int i=0; i<index+1; i++){finalArray[i] = newArray[i];}
/*
        int windowRight = 0;
        for (int j =0; j< finalArray.length;j++){
            if (windowRight == j) currentSum += finalArray[j];
            else if (windowRight < j) windowRight = j;
            while(currentSum>0 && windowRight< finalArray.length-1){
                windowRight += 1;
                currentSum+=finalArray[windowRight];
                maxSum = Math.max(currentSum,maxSum);
            }
            maxSum = Math.max(currentSum,maxSum);
            currentSum -= finalArray[j];
            if(currentSum<0) currentSum =0;
        }
 */
        int left = 0;
        for (int right = 0; right< finalArray.length;right++){
            currentSum += finalArray[right];
            maxSum = Math.max(currentSum,maxSum);
            while (currentSum < 0){
                currentSum -= finalArray[left];
                left++;
            }
        }
        return maxSum;
    }
}
