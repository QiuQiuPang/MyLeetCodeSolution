import java.util.ArrayList;
import java.util.List;

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
class Solution_655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList();
        int height = getHeight(root,0);
        int width = (int) Math.pow(2,height) -1;
        List<String> row = new ArrayList();
        for(int i = 0; i<width;i++) row.add("");
        for(int i = 0; i<height;i++) result.add(new ArrayList(row));
        fillTheList(0,height,result,root,0, width);
        return result;
    }

    public void fillTheList(int level, int height, List<List<String>> result, TreeNode root, int left, int right){
        if(level == height || root == null) return;
        Integer val = root.val;
        int mid = (left+right)/2;
        result.get(level).set(mid , val.toString());
        fillTheList(level+1,height, result, root.left, left, mid-1);
        fillTheList(level+1,height, result, root.right, mid+1, right);
    }

    public int getHeight(TreeNode root, int height){
        if(root == null) return height;
        else return Math.max(getHeight(root.left,height+1),getHeight(root.right,height+1));
    }
}