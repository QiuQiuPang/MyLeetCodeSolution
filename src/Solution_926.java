import java.util.ArrayList;
import java.util.List;

public class Solution_926 {

    public static void main(String[] args) {
        Pack pack = new Pack("1","2");
        List<Pack> packList = new ArrayList<>();
        packList.add(pack);
        Pack pack2 = new Pack("3","4");
        Pack temp = packList.get(0);
        packList.set(0,pack2);
        pack2 = temp;
        packList.add(pack2);


        System.out.println(minFlipsMonoIncr("0010011110"));
    }

    public static class Pack{

        public Pack(String yi, String er) {
            this.yi = yi;
            this.er = er;
        }

        public String getYi() {
            return yi;
        }

        public void setYi(String yi) {
            this.yi = yi;
        }

        String yi;

        public String getEr() {
            return er;
        }

        public void setEr(String er) {
            this.er = er;
        }

        String er;
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
