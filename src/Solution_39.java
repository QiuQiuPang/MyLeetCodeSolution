import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        realCombine(candidates, target, candidates.length-1, result, temp);
        return result;
    }

    public static void realCombine(int[] candidates, int target, int index, List<List<Integer>> result,ArrayList<Integer> temp){
        if(target == 0) {
            result.add((List<Integer>) temp.clone());
        }
        if(index<0 || target<=0) return;
        int cur = candidates[index], count = target/cur;
        for(int i=0; i<count; i++){temp.add(cur);}
        for(int i=count; i>0; i--){
            realCombine(candidates, target-(cur*i), index-1, result, temp);
            Integer curInteger = cur;
            temp.remove(curInteger);
        }
        realCombine(candidates, target, index-1, result, temp);
    }
}
