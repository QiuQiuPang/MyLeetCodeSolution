import java.util.Arrays;

public class Solution_703 {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        kthLargest.add(2);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }

    static class KthLargest {
        private ListNode head;
        private final int k;

        public KthLargest(int k, int[] nums) {
            Arrays.sort(nums);
            head = nums.length==0? null: new ListNode(nums[nums.length-1]);
            ListNode prev = head;
            for(int i = nums.length-2; i>=0; i--){
                ListNode node= new ListNode(nums[i]);
                prev.next = node;
                prev = node;
            }
            this.k = k;

        }

        public int add(int val) {
            ListNode node = new ListNode(val);
            boolean insert = true;
            if(head == null || val>head.val){
                node.next = head;
                head = node;
                insert = false;
            }
            ListNode left = head, right = head.next;
            int result = 0, count = k;
            while(right!=null){
                count--;
                if(left.val>=val && right.val < val && insert){
                    left.next = node;
                    node.next = right;
                    right = node;
                    insert = false;
                }
                if(count==0){
                    result = left.val;
                }
                left = right;
                right = right.next;
            }
            if(left.val>val){
                left.next = node;
            }
            if(count==1){
                result = left.val;
            } else if(count == 2){
                result = left.next.val;
            }
            return result;
        }
    }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
