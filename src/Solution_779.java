public class Solution_779 {

    /**
     * 0
     * 01
     * 0110
     * 01101001
     * 0110100110010110
     * 1234567890123456
     *
     * 15 - 8 = 7
     * 7 - 4 = 3
     * 3 - 2 = 1
     *
     * 13 - 8 = 5
     * 5 - 4 = 1
     *
     * 7/2=3
     * 3/2=1
     *
     * 14/2=7
     */
    // observation: use helper method to find how many times could k iterate to 1 by subtracting the nearest 2^x
    public static void main(String[] args) {
        System.out.println(kthGrammar(30,4));
    }

    public static int kthGrammar(int n, int k) {
        int count = 0;
        while(k>1){
            int x = findNearestPoser(k);
            k-= Math.pow(2,x);
            count++;
        }
        return count%2==0?0:1;
    }

    public static int findNearestPoser(int k){
        int x = (int) (Math.log(k-1)/Math.log(2));
        return x;
    }

}
