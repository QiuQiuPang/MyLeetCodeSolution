class Solution_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        rotate(nums,29);
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k%len==0) return;
        rotating(nums,0,k);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] rotating(int[] nums, int l, int k){
        int len = nums.length-l;
        k %= len;
        int k2 = (len%k)==0?1:k%(len%k);
        for(int i =0; i<len;i++){
            if(i/k == len/k) {
                if(len%k<2) break;
                return rotating(nums,i+l,k%(len%k));
            }
            else swap(nums,i+l,nums.length-k+i%k);
        }
        return nums;
    }
}