import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_sp_map_01 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums1){
            if(map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }
            else{
                map.put(x, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for(int y: nums2){
            if(map.containsKey(y)){
                resultList.add(y);
                if(map.get(y)==1){
                    map.remove(y);
                }else{
                    map.put(y, map.get(y)-1);
                }
            }
        }
        return resultList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
