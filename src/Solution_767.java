
public class Solution_767 {

    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvse"));
    }

    public static String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i=0; i<s.length();i++){
            char cur = s.charAt(i);
            count[(int) cur - (int) 'a']++;
        }
        int max = 0, maxIndex = 0, total = s.length();
        for (int j=0; j<26; j++){
            if(count[j]>max){
                max = count[j];
                maxIndex = j;
            }
        }
        int x = 0, y=0, last = -1;
        char[] result = new char[s.length()];
        while(count[maxIndex]!=0){
            if(y>=s.length()) return "";
            result[y] = (char) ('a'+maxIndex);
            y+=2;
            count[maxIndex]--;
            total--;
        }
        while(total!=0){
            while(count[x]!=0){
                if(y>=s.length()) y =1;
                result[y] = (char) ('a'+x);
                y+=2;
                count[x]--;
                total--;
            }
            x = (x+1)%26;
        }
        return String.copyValueOf(result);
    }

}
