import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int status = 0;
        addSubList(result, new ArrayList<>(), nums, status);
        return result;
    }

    public static void addSubList( List<List<Integer>> result, List<Integer> subList, int[] nums, int status ){
        if(status + 1 == (1<< nums.length)){
            result.add(new ArrayList<>(subList));
            return;
        }
        Integer prev = null;
        for(int i = 0; i < nums.length; i++){
            if( (status & (1<< (i))) != 0 || (prev != null && prev == nums[i] ) ){
                continue;
            }
            subList.add(nums[i]);
            status |= (1 << ( i ) );
            addSubList(result, subList , nums, status);
            status &= ~(1 << ( i ) );
            subList.remove(subList.size() - 1);
            prev = nums[i];
        }
    }
}
