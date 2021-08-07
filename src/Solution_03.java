import java.util.HashMap;
import java.util.HashSet;

public class Solution_03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aVbcdDacAdb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        HashMap<Character, Integer> appeared = new HashMap<>();
        HashSet<Character> repeated = new HashSet<>();
        int left = 0;
        for(int right=0;right<s.length();right++){
            char tempKey = s.charAt(right);
            if (!appeared.isEmpty() && appeared.containsKey(tempKey)){
                appeared.replace(tempKey, appeared.get(tempKey)+1);
                if(appeared.get(tempKey) > 1) repeated.add(tempKey);
            }
            else appeared.put(tempKey,1);
            if(!repeated.isEmpty()) {
                char tempLeft = s.charAt(left);
                if (appeared.get(tempLeft) == 2) repeated.remove(tempLeft);
                appeared.replace(tempLeft, appeared.get(tempLeft) - 1);
                left++;
            }
            max = right - left + 1;
        }

        return max;
    }

}
