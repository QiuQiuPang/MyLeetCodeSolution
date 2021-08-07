public class Solution_Sward_13 {
    public static void main(String[] args) {
        System.out.println(movingCount(38,15,9));
    }
    public static int movingCount(int m, int n, int k) {
        if(m>n) {int t = n; n = m; m = t;}
        int i, j=0;
        if(n>10) i = n/10 + 9;
        else i = n;
        if(i>k+1) i = k+1;
        int[] nMove = new int[i];
        i--;
        while(i>-1 && j<m){
            if(j==m-1){
                while (i>-1){nMove[i--] = j>8?9+(j+1)/10*10:j+1;}
            }
            else {
                if((j/10 + j%10) == k-i) nMove[i--] = j>8?9+(j+1)/10*10:j+1;
            }
            j++;
        }
        int sum = 0;
        for(j = 0; (j/10 + j%10)<nMove.length && j<n ;j++){
            sum+=nMove[j/10+j%10];
        }
        return sum;
    }
}
