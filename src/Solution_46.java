import java.util.ArrayList;
import java.util.List;

public class Solution_46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int status = 0;
        addSubList(result, new ArrayList<>(), nums, status);
        return result;
    }

    public static void addSubList( List<List<Integer>> result, List<Integer> subList, int[] nums, int status ){
        if(status + 1 == (1<< nums.length)){
            result.add(new ArrayList<>(subList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if ((status & (1<< (i))) != 0){
                continue;
            }
            subList.add(nums[i]);
            status |= (1 << ( i ) );
            addSubList(result, subList , nums, status);
            status &= ~(1 << ( i ) );
            subList.remove(subList.size() - 1);
        }
    }
}
