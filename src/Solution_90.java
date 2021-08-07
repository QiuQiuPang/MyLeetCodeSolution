import java.util.*;

class Solution_90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2,3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        subsetBuilder(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public static void subsetBuilder(List<List<Integer>> result,  List<Integer> subset, int[] nums, int pointer){
        // push case
        if(pointer>=nums.length){
            return;
        }
        subset.add(nums[pointer]);
        result.add(new ArrayList(subset));
        subsetBuilder(result, subset, nums,pointer+1);

        // no push case
        subset.remove(subset.size()-1);
        while(pointer<nums.length-1 && nums[pointer]==nums[pointer+1]){
            pointer++;
        }
        subsetBuilder(result, subset, nums, pointer+1);
    }
}