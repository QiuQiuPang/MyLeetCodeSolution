public class Solution_1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bsbininm","jmjkbkjkv"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] table = new int[text2.length()+1][text1.length()+1];
        for(int i=1; i<text2.length()+1;i++){
            for(int j=1; j<text1.length()+1; j++){
                int prev = Math.max(table[i-1][j],table[i][j-1]);
                if(text2.charAt(i-1)==text1.charAt(j-1)) prev=table[i-1][j-1]+1;
                table[i][j] = prev;
            }
        }
        return table[text2.length()][text1.length()];
    }
}
