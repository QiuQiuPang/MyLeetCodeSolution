public class Solution_724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums) {
        boolean alterMethod = true;
        if (!alterMethod) {
            int[] result = new int[nums.length];
            int sum = 0;
            for(int i=nums.length-2; i>=0;i--){
                sum+=nums[i+1];
                result[i] = sum;
            }
            if(result[0]==0 ){
                return 0;
            }
            sum=0;
            for(int j=1; j<nums.length;j++){
                sum+=nums[j-1];
                if(result[j]==sum){
                    return j;
                }
            }
            return -1;
        }
        else{
            int sumRight=0;
            for(int i=nums.length-2; i>=0;i--){
                sumRight+=nums[i+1];
            }
            if (sumRight == 0) return 0;
            int sumLeft = 0;
            for(int j=1; j<nums.length;j++){
                sumLeft+=nums[j-1];
                sumRight-=nums[j];
                if (sumLeft==sumRight){
                    return j;
                }
            }
            return -1;

        }

    }
}
