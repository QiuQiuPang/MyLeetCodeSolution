import java.util.Arrays;
import java.util.LinkedList;

public class Solution_142 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        System.out.println(detectCycle(a));
    }



        public static ListNode detectCycle(ListNode head) {
            if(head == null) return null;
            ListNode slow = head;
            ListNode fast = head;

            do{
                if(fast.next == null || fast.next.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
            }while(fast!=slow);

            slow = head;
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }

            return fast;

        }

}


 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;

      ListNode() {}
      ListNode(int x) {
          val = x;
          next = null;
      }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

