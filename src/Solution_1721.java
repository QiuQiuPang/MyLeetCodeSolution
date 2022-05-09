public class Solution_1721 {
    public static void main(String[] args) {
        ListNode th = new ListNode(5);
        ListNode tw = new ListNode(8, th);
        ListNode on = new ListNode(7, tw);
        System.out.println(swapNodes(on, 2));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), right = dummy, rightLead = head, left = dummy;
        int length = 0;
        boolean sp = false;
        while(rightLead!=null){
            length++;
            rightLead = rightLead.next;
        }
        k = k>(length+1)/2 ? length + 1 - k : k;
        if(k == length/2) sp = true;
        rightLead = dummy;
        for(int i = 0; i < k; i++){
            rightLead = rightLead.next;
        }
        while(rightLead.next!=null){
            k--;
            if(k == 1){
                left = right.next;
            }
            right = right.next;
            rightLead = rightLead.next;
        }
        if(sp){
            ListNode temp = right.next.next;
            left.next = right.next;
            left.next.next = right;
            right.next = temp;
        }else{
            ListNode tempRn = right.next.next;
            ListNode tempLn = left.next.next;
            ListNode tempL = left.next;
            ListNode tempR = right.next;
            left.next.next = tempRn;
            right.next.next = tempLn;
            left.next = tempR;
            right.next = tempL;
        }
        return dummy.next;

    }
}
