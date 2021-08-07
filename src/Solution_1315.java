import javafx.util.Pair;

import java.util.*;

class solution_1315{
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        // assume first int indicate the length of N
    /*
    int N = scanner.nextInt();
    String[] arrayInput = new String[N];
    for(int i=0; i<N; i++){
      // how to deal null case ？？？
      arrayInput[i] = scanner.next();
    }*/
        List<String> listInput = new ArrayList<>();
        while(scanner.hasNext()){
            listInput.add(scanner.next());
        }
        String[] arrayInput = new String[listInput.size()];
        arrayInput = listInput.toArray(arrayInput);
        int N = arrayInput.length;

        //System.out.println(Arrays.toString(arrayInput));

        TreeNode[] treeTable = new TreeNode[N];
        for(int j = 0; j<N; j++){
            if(arrayInput[j].equals("null")) treeTable[j] = null;
            else treeTable[j] = new TreeNode(Integer.valueOf(arrayInput[j]));
        }
        for(int k = 0; k<N; k++){
            if((k*2+1)<N) treeTable[k].left = treeTable[k*2+1];
            if((k*2+2)<N) treeTable[k].right = treeTable[k*2+2];
        }
        //5(N) [2 1 3 null 5]
        System.out.println(Soltuion(treeTable[0]));


    }
    // Given a binary tree, return the sum of values of nodes with even-valued
    // grandparent.  (A grandparent of a node is the parent of its parent,
    // if it exists.
    // If there are no nodes with an even-valued grandparent, return 0.

    public static int Soltuion(TreeNode root){

        // use bfs, using queue, traverse the tree, define a depth
        // if current depth -2 > 0, store the nodes
        // [1,2,3,4,5,6,7]
        // 1
        // 2,1 3,1
        // 3,1 4,2,1 5,2,1
        // 4,2,1 5,2,1 6,3,1 7,3,1
        // define a tempCount = the count of nodes which have same gramdparetns
        // tempcount = 2^N --> store grand
        // Use QUEUE to traverse the tree, including a int[] store thier parents and grand
        // define a sum and hashset (store the grandparents)
        int sum = 0;
        Map<TreeNode, int[]> parentTable = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        parentTable.put(cur,new int[2]);
        while(!queue.isEmpty()){
            cur = queue.poll();
            // visit
            // if(parentTable.contains(cur))
            int[] parent = parentTable.get(cur);
            if(parent[1]!=0 && parent[1]%2==0){
                sum += cur.val;
            }
            int[] childParent = new int[2];
            childParent[0] = cur.val;
            childParent[1] = parent[0];
            if(cur.left!=null) {
                // creat parent table for left child
                // child's parent is cur and grand is cur's parent
                parentTable.put(cur.left, childParent);
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                parentTable.put(cur.right, childParent);
                queue.offer(cur.right);
            }
        }
        return sum;
    }
}
/*
class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/
