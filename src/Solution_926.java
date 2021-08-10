public class Solution_926 {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("0010011110"));
    }

    public static int minFlipsMonoIncr(String s) {
        // @TODO 重做
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int sumOne = 0;
        for(int i=0; i<chars.length;i++){
            if(chars[i]=='1'){
                sumOne++;
            }
            dp[i] = sumOne;
        }
        sumOne = Math.min(chars.length-sumOne,sumOne);
        int sumRight = 0;
        for(int j=chars.length-1;j>0;j--){
            if(chars[j]=='0'){
                sumRight++;
            }
            dp[j] = sumRight;
            if(dp[j]+dp[j-1]<sumOne){
                sumOne = dp[j]+dp[j-1];
            }
        }
        return sumOne;

    }
}
