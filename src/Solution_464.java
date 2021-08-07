public class Solution_464 {

    public static void main(String[] args) {

        System.out.println(canIWin(20,100));

    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] choosableArray = new int[maxChoosableInteger];
        for (int i=1;i<=maxChoosableInteger;i++) choosableArray[i-1] = i;
        return winCheck(choosableArray, desiredTotal,1);
    }

    public static boolean winCheck(int[] choosableArray, int desiredTotal,int depth) {
        // ============ get some values ============
        // depth odd = 1st player, depth even = 2nd player
        boolean player = depth%2==1;

        // ============ leaf decision ============
        if(choosableArray.length>= desiredTotal){
            for(int i=choosableArray.length-1; i>=0;i--) {
                if(choosableArray[i] !=0) {
                    if (choosableArray[i] >= desiredTotal) {
                        return player;
                    }
                    break;
                }
            }
        }
        if(depth == choosableArray.length) return false;

        // ============ node decision ============
        boolean mightWin = false;
        boolean mustLoss = true;
        for(int i=0; i<choosableArray.length;i++){
            if(mightWin||!mustLoss) break;
            if(choosableArray[i]!=0) {
                int tempValue = choosableArray[i];
                choosableArray[i] = 0;
                if (player) {
                    mightWin = winCheck(choosableArray, desiredTotal-tempValue,depth+1);
                } else {
                    mustLoss = winCheck(choosableArray, desiredTotal-tempValue,depth+1);
                }
                choosableArray[i] = tempValue;
            }

        }
        if(player) return mightWin;
        else return mustLoss;
    }


}
