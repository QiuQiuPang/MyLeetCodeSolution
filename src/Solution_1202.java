import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] charArray = s.toCharArray();
        List<Integer>[] list= new List[charArray.length];
        boolean[] visited = new boolean[charArray.length];
        for(List<Integer> pair: pairs){
            int left = pair.get(0), right = pair.get(1);
            if(list[left]==null) list[left] = new ArrayList();
            if(list[right]==null) list[right] = new ArrayList();
            list[left].add(right);
            list[right].add(left);
        }
        for(int i = 0; i < charArray.length; i++){
            UFSet ufs = new UFSet();
            ufs.find(i, list, charArray, visited);
            ufs.sort(charArray);
        }
        return  String.copyValueOf(charArray);
    }
}


class UFSet{
    List<Integer> indexs = new ArrayList<>();
    List<Character> chars = new ArrayList<>();

    public void find(int cur, List<Integer>[] list, char[] array, boolean[] visited){
        if(visited[cur]) return;
        indexs.add(cur);
        chars.add(array[cur]);
        visited[cur] =  true;
        for(Integer next : list[cur]){
            find(next, list, array, visited);
        }
    }

    public void sort(char[] array){
        if(indexs == null || indexs.size() == 1) return;
        indexs.sort(Comparator.naturalOrder());
        chars.sort(Comparator.naturalOrder());
        for(int i = 0; i < indexs.size(); i++){
            array[indexs.get(i)] = chars.get(i);
        }
    }

}