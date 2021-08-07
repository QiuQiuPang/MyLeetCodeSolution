public class Solution_04 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] Left,Right;
        if(nums1.length>=nums2.length) {
            Left = nums2;
            Right = nums1;
        }
        else{
            Left = nums1;
            Right = nums2;
        }
        int m,n,imax,imin,i=0,j=0,max,min;
        m = Left.length;
        n = Right.length;
        imax = m;
        imin = 0;
        while(imin<=imax){
            i = (imax+imin)/2;
            j = (m+n+1)/2-i;
            if(i>0 && Left[i-1] > Right[j]) imax = i-1;
            else if(i<m && Left[i] < Right[j-1]) imin = i+1;
            else break;
        }
        if(i==0) max = Right[j-1];
        else if (j==0) max = Left[i-1];
        else max = Math.max(Right[j-1],Left[i-1]);
        if((m+n)%2==1) return max;

        if(i==m) min = Right[j];
        else if(j==n) min = Left[i];
        else min = Math.min(Right[j],Left[i]);

        return (double) (max + min)/2;
    }
}
