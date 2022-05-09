import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] array = new List[nums.length+1];
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) +1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(array[entry.getValue()]==null){
                array[entry.getValue()] = new ArrayList<>();
            }
            array[entry.getValue()].add(entry.getKey());
        }
        List<Integer> resultList = new ArrayList<>();
        for(int i = nums.length; i>0; i--){
            if(array[i]!=null) resultList.addAll(array[i]);
            if(resultList.size()==k) break;
        }
        return resultList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
