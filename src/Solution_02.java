public class Solution_02 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l1Pointer = l1;
            int over10 = 0;
            int tempSum = 0;
            while(l1!=null && l2!= null){
                tempSum = l1.val + l2.val + over10;
                over10 = tempSum/10;
                l1.val = tempSum%10;
                if(l1.next==null || l2.next== null) break;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1.next!=null || l2.next!= null){
                l1.next = l1.next!=null?l1.next:l2.next;
                l1 = l1.next;
                while(l1!= null){
                    tempSum = l1.val+over10;
                    over10 = tempSum/10;
                    l1.val = tempSum%10;
                    if(l1.next == null) break;
                    l1 = l1.next;
                }
            }
            if(over10!=0)l1.next = new ListNode(1);

            return l1Pointer;
        }
    }
