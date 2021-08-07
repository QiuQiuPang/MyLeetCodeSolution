import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution_1438 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10,1,2,2,2,2,3,4,8},5));
    }

    public static int longestSubarray1(int[] nums, int limit) {

        // minMax, position 1 holds the index of minValue, 2 holds value of min, 3 maxIndex 4 Max
        int[] minMax = new int[4];
        int length = 0;
        int left = 0;
        for(int right = 0; right< nums.length; right++){
            if (left == right) {
                minMax = new int[]{left, nums[left], right, nums[right]};
            }
            int diff = Math.abs(nums[right]-nums[Math.min(minMax[0],minMax[2])]);
            if(Math.abs(nums[right]-nums[Math.min(minMax[0],minMax[2])])>limit && left!= right-1){
                left = Math.min(minMax[0],minMax[2])+1;
                if(left == minMax[0]+1){
                    int temp = minMax[1];
                    minMax[0] = left;
                    minMax[1] = nums[left];
                    for(int min = left; min <= right; min++){
                        if(nums[min] == temp){
                            minMax[0] = min;
                            minMax[1] = nums[min];
                        }
                        else if(nums[min]<minMax[1]){
                            minMax[0] = min;
                            minMax[1] = nums[min];
                        }
                    }
                }
                else{
                    int temp = minMax[3];
                    minMax[2] = left;
                    minMax[3] = nums[left];
                    for(int max = left; max <= right; max++){
                        if(nums[max] == temp){
                            minMax[0] = max;
                            minMax[1] = nums[max];
                        }
                        else if(nums[max]>minMax[3]){
                            minMax[2] = max;
                            minMax[3] = nums[max];
                        }
                    }
                }
                right--;
            }
            else if(Math.abs(nums[right]-nums[Math.max(minMax[0],minMax[2])])>limit){
                left = Math.max(minMax[0],minMax[2])+1;
                right = left;
                minMax = new int[]{left, nums[left], right, nums[right]};
            }
            else if(nums[right] < minMax[1]){
                minMax[0] = right;
                minMax[1] = nums[right];
            }
            else if (nums[right]> minMax[3]){
                minMax[2] = right;
                minMax[3] = nums[right];
            }
            length = Math.max(length,right-left+1);
        }


        return length;
    }

    public static int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }


}
