import java.util.ArrayList;
import java.util.List;

public class Solution_438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }

    public static List<Integer> findAnagrams(String s2, String s1) {
        int[] traverse = new int[26];
        List<Integer> result = new ArrayList<>();
        int lengthS1 = s1.length();
        for(int i=0; i<lengthS1; i++){
            traverse[s1.charAt(i)-'a']++;
        }
        int left = 0 , right= 0;
        int lengthS2 = s2.length();
        while(right<lengthS2){
            traverse[s2.charAt(right)-'a']--;
            right++;
            while(traverse[s2.charAt(right-1)-'a']<0){
                if(left>lengthS2-lengthS1) break;
                traverse[s2.charAt(left)-'a']++;
                left++;
            }
            if(right-left == lengthS1){
                result.add(left);
            }
        }
        return result;
    }
}
