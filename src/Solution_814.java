/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        boolean isRnull = (root.right==null);
        boolean isLnull = (root.left==null);
        if(isRnull && !isLnull) root.left = pruneTree(root.left);
        else if(isLnull && !isRnull) root.right = pruneTree(root.right);
        else {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }
        if(root.right == null && root.left== null && root.val == 0) return null;
        return root;
    }
}