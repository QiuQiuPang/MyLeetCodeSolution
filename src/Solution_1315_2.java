import java.util.*;

class solution_1315_1{
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
        Queue<QueueEntry> queue = new LinkedList<>();
        QueueEntry cur = new QueueEntry(root, 0,0);
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            // visit
            if(cur.gran!=0 && cur.gran%2==0){
                sum += cur.root.val;
            }
            if(cur.root.left!=null) {
                // child's parent is cur and grand is cur's parent
                queue.offer(new QueueEntry(cur.root.left, cur.root.val, cur.par));
            }
            if(cur.root.right!=null) {
                queue.offer(new QueueEntry(cur.root.right, cur.root.val, cur.par));
            }
        }
        return sum;
    }
}
class QueueEntry{
    TreeNode root;
    int par, gran;
    public QueueEntry(TreeNode root, int par, int gran){
        this.root = root;
        this.gran = gran;
        this.par = par;
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
