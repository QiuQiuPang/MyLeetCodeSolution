import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_18 {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-1,0,2,4,5},0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.toArray();
        int theLength = nums.length;
        for(int i = 0; i<theLength-3;i++){
            for(int j = theLength-1; j>i+2;j--){
                int l = i+1;
                int r = j-1;
                while(l<r){
                    int res = target-nums[i]-nums[j]-nums[l]-nums[r];
                    if(res < 0) r--;
                    else if(res > 0 ) l++;
                    else {
                        result.add(Arrays.asList(nums[i],nums[l],nums[r],nums[j]));
                        while(l<r && nums[l+1]==nums[l]) l++;
                        while(l<r && nums[r-1]==nums[r]) r--;
                        l++;
                        r--;
                    }
                }
                while(j>i+2 && nums[j-1] == nums[j]) j--;
            }
            while(i<theLength-3 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }
}
