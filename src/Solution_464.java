import java.util.HashMap;

public class Solution_464 {

    public static void main(String[] args) {

//        String src = "aabbccdd";
//        String dest = String.copyValueOf(src.toCharArray(), 1, 5);
//        System.out.println(dest);
        System.out.println(canIWin(10,11));

    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        HashMap<Integer, Boolean> map = new HashMap<>();
        return winCheck((int) Math.pow(2, maxChoosableInteger) - 1 , maxChoosableInteger , desiredTotal,1, map);
    }

    public static boolean winCheck(int state, int maxInteger, int desiredTotal,int depth, HashMap<Integer, Boolean> map) {
        // ============ get some values ============
        // depth odd = 1st player, depth even = 2nd player
        boolean player = depth%2==1;
        int genState = (state<<9) + desiredTotal;

        // ============ leaf decision ============
        if(map.get(genState)!= null){
            return map.get(genState);
        }
        if(maxInteger>= desiredTotal){
            for(int i= maxInteger; i>0;i--) {
                if( (state & (1<<(i-1))) > 0) {
                    if ( i >= desiredTotal) {
                        map.put(genState, player);
                        return player;
                    }
                    break;
                }
            }
        }

        // ============ node decision ============
        boolean mightWin = false;
        boolean mustLoss = true;
        for(int i= maxInteger; i>0;i--){
            if(mightWin||!mustLoss) break;
            if((state & (1<<i)) > 0) {
                if (player) {
                    mightWin = winCheck( state-(1<<i), maxInteger, desiredTotal-i-1,depth+1, map);
                } else {
                    mustLoss = winCheck(state-(1<<i), maxInteger, desiredTotal-i-1,depth+1, map);
                }
            }

        }
        if(player) {
            map.put(genState,mightWin);
            return mightWin;
        }
        else {
            map.put(genState, mustLoss);
            return mustLoss;
        }
    }


}
