import java.util.*;

public class Solution_1367 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4,new ListNode(2,new ListNode(8)));
        TreeNode root = new TreeNode(1, new TreeNode(4,null,new TreeNode(2, new TreeNode(1),null)), new TreeNode(4,new TreeNode(2,new TreeNode(6), new TreeNode(8,new TreeNode(1), new TreeNode(3))),null));
        System.out.println(isSubPath(head, root));

    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek()!=null){
            TreeNode curr = queue.poll();
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
            if(curr.val == head.val) if(rootSubPath(head, curr)) return true;
        }
        return false;
    }

    public static boolean rootSubPath(ListNode head, TreeNode root){

        if(head==null) return true;
        else if(root==null) return false;
        else return head.val==root.val && (rootSubPath(head.next,root.left) || rootSubPath(head.next,root.right));
    }
}
