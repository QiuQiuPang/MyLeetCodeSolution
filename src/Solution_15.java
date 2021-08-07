import java.util.*;

public class Solution_15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums)
    {
        int left,right,v1,v2,v3;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            if(nums[i] > 0) break;
            left = i +1;
            right = nums.length-1;
            while(left<right){
                v1 = nums[i];
                v2 = nums[left];
                v3 = nums[right];
                if(v1+v2+v3 == 0){
                    result.add(Arrays.asList(v1,v2,v3));
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(v1+v2+v3<0) left++;
                else right--;
            }
        }
        return result;
    }
}

/*{
        Set<List<Integer>> repeat = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-nums[j] - nums[i])) {
                    int[] tempArray = new int[]{nums[i],-nums[j]-nums[i],nums[j]};
                    Arrays.sort(tempArray);
                    List<Integer> temp = new ArrayList<>();
                    for(int k:tempArray) temp.add(k);
                    if(!repeat.contains(temp)) repeat.add(temp);
                } else map.put(nums[j], j);
            }
        }

        List<List<Integer>> result = new ArrayList<>(repeat);
        return result;

    }
*/


