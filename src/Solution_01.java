import java.util.*;

public class Solution_01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            else map.put(nums[i], i);
        }
        return null;
    }

    /*
    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> oldNums = new ArrayList<>();
        for (int i : nums) oldNums.add(i);
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int leftValue = nums[left];
            int rightValue = nums[right];
            if(leftValue+rightValue == target){
                int index1 = oldNums.indexOf(leftValue);
                int index2;
                if(leftValue == rightValue){
                    oldNums.remove(index1);
                    index2 = oldNums.indexOf(rightValue)+1;
                }
                else index2 = oldNums.indexOf(rightValue);
                return new int[]{index1,index2};
            }
            else if (leftValue+rightValue < target) left++;
            else right--;
        }
        return null;
    }*/



}
