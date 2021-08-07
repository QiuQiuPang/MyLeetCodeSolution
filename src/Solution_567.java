public class Solution_567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc","dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] traverse = new int[26];
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
                if(left>lengthS2-lengthS1) return false;
                traverse[s2.charAt(left)-'a']++;
                left++;
            }
            if(right-left == lengthS1){
                return true;
            }
        }
        return false;
    }
}
