import java.util.ArrayList;
import java.util.List;

class Solution_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        char[][] dict = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'x','y','z'}};
        dfs(result, digits, dict, 0, new char[digits.length()]);
        return result;
    }

    public void dfs(List<String> output, String digits, char[][] dict, int index, char[] fromParent){
        if(index == digits.length()-1){
            for(char c: dict[digits.charAt(index)-'2']){
                fromParent[index] = c;
                output.add(String.valueOf(fromParent));
            }
            return;
        }
        for(char c: dict[digits.charAt(index)-'2']){
            fromParent[index] = c;
            dfs(output, digits, dict, index+1, fromParent);
        }
    }
}