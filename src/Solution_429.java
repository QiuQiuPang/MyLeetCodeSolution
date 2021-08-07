import java.util.*;

public class Solution_429 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        Node root = new Node(1,new ArrayList<Node>(Arrays.asList(new Node(2, new ArrayList<Node>( Arrays.asList(new Node(4)))), new Node(3))));
        result = levelOrder(root);
        for(List<Integer> sub : result){
            for(Integer cur:sub){
                System.out.println(cur);
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        //BFS store the next level nodes in temp array before we finished the traverse of cur level
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        List<Integer> sub = new ArrayList<>();
        Queue<Node> tree = new LinkedList<>();
        tree.add(root);
        // consume size as the count of remaining nodes in cur level
        int size = 1;
        // count up sizeNext as the number of nodes in next level
        int sizeNext = 0;
        while(!tree.isEmpty()){
            Node cur = tree.remove();
            List<Node> children = cur.children;
            if (children!=null) {
                sizeNext += children.size();
                for(Node child : children){
                    tree.add(child);
                }
            }
            sub.add(cur.val);
            size--;
            if(size==0){
                result.add(sub);
                sub = new ArrayList<>();
                size=sizeNext;
                sizeNext=0;
            }
        }
        return result;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}