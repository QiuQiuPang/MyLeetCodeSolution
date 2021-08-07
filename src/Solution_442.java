import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution_442 {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{39,31,8,14,14,38,5,15,29,49,18,6,30,47,8,35,2,17,6,10,29,46,41,48,1,36,5,28,46,39,7,47,18,42,17,11,36,45,21,33,24,10,24,50,25,16,9,12,11,25}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        /*int k = 0;
        List<Integer> result = new ArrayList<>();
        for(int i:nums){
            if((k&(1<<i-1))>0){
                result.add(i);
            }
            k = k|(1<<i-1);
        }
        return result;
        */
        int i = 0;
        int temp = 0;
        List<Integer> result = new ArrayList<>();
        while(i<nums.length){
            if(nums[i] > 0 && nums[i]!=i+1){
                temp = nums[nums[i]-1];
                if(nums[nums[i]-1] ==nums[i]){
                    result.add(nums[i]);
                    temp = -1;
                }

                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }
        return result;
    }
}
