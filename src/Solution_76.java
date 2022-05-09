import java.util.HashMap;
import java.util.Map;

public class Solution_76 {

    public static void main(String[] args) {
        System.out.println(minWindow("A", "C"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int tCount = t.length();
        int sLenght = s.length();
        if(tCount==1) {
            for(int i =0;i<sLenght; i++){
                if(s.charAt(i)==t.charAt(0)){
                    return t;
                }
            }
            return "";
        }
        for(int i=0; i< tCount; i++ ){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1 );
        }
        int left = 0, right = 0;
        String result = "";
        while(right<sLenght && left<=right){
            while(tCount>0 && right<sLenght){
                Character cur = s.charAt(right);
                if(map.containsKey(cur)){
                    int value = map.get(cur);
                    map.put(cur, value-1);
                    if(value>0){
                        tCount--;
                    }
                }
                right++;
            }
            if((tCount<1 && result.equals("")) || right-left<result.length()){
                result = s.substring(left, right);
            }
            while(tCount<1 && left<right){
                Character cur = s.charAt(left);
                if(map.containsKey(cur)){
                    int value = map.get(cur);
                    if(value==0){
                        tCount++;
                        if(right-left<result.length()){
                            result = s.substring(left, right);
                        }
                    }
                    map.put(cur, value+1);
                }
                left++;
            }
        }
        return result;
    }
}
