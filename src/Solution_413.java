public class Solution_413 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,7,9,11,13,15}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length<3) return 0;
        int[] diff = new int[nums.length-1];
        int temp = nums[0];
        for(int i=0;i<nums.length-1;i++){
            diff[i] = nums[i+1] - temp;
            temp += diff[i];
        }
        int same = 0;
        int count = 0;
        for(int j=0;j<diff.length-1;j++){
            if(diff[j]==diff[j+1]){
                same++;
            }
            else{
                same=0;
            }
            count+= same;
        }

        return count;
    }


    /*
    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length<3) return 0;
        int diff = 0;
        int tempDiff = 0;
        int temp = nums[0];
        int same = 0;
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            diff = nums[i+1] - temp;
            temp = nums[i+1];
            if(i>0 && diff == tempDiff){
                same++;
                count +=same;
            }
            else if(same!=0) same = 0;
            tempDiff = diff;
        }
        return count;

    }*/
}
