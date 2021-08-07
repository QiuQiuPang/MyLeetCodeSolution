import java.util.Stack;

public class Solution_98 {
    public static void main(String[] args) {
        TreeNode rightNode = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode root = new TreeNode(5, new TreeNode(1), rightNode);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer Min, Integer Max) {
        if (root == null) return true;
        else if (Max != null && root.val >= Max) return false;
        else if (Min != null && root.val <= Min) return false;
        else return isValidBST(root.left, Min, root.val) && isValidBST(root.right, root.val, Max);
    }
/*
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // what if smaller
        int prev = Integer.MIN_VALUE;
        TreeNode cur = root;
        while(cur!= null || !stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev == Integer.MIN_VALUE) prev = cur.val;
            else if(cur.val <= prev) return false;
            else prev = cur.val;
            cur = cur.right;
        }
        return true;
    }

*/
}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
