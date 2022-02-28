
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
class Solution_148 {

    public static void main(String[] args) {
        ListNode tail = new ListNode(8);
        ListNode subTail = new ListNode(18, tail);
        ListNode subHead = new ListNode(4, subTail);
        ListNode head = new ListNode(19, subHead);
        sortList(head);

    }

    // 额外函数： merge -> 取得两个List，双指针遍历互比大小组合拼接，返回Node
    // 递归逻辑： sort 输入Node返回Node
    //  base case： 当前node无next时返回自身
    //  cond case： 快慢指针将一个list拆成两个，然后分别执行sort，最后执行merge，返回merge后的node
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else if(head.next.next == null){
            ListNode subHead = head.next;
            head.next = null;
            return mergeLists(head, subHead);
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode subHead = slow.next;
        slow.next = null;
        return mergeLists(sortList(head), sortList(subHead));
    }

    public static ListNode mergeLists(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null? node2 : node1;
        }
        ListNode headNode = null;
        if(node1.val < node2.val){
            headNode = node1;
            node1 = node1.next;
        }else{
            headNode = node2;
            node2 = node2.next;
        }
        ListNode pointer = headNode;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                pointer.next = node1;
                pointer = pointer.next;
                node1 = node1.next;
            }else{
                pointer.next = node2;
                pointer = pointer.next;
                node2 = node2.next;
            }
        }
        pointer.next = node1 == null? node2: node1;
        return headNode;
    }
}