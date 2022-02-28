import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Definition for a Node.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution_133 {
    // DFS：
    // 基本思路 ： HashTable 储存已经遍历过的 旧Node，HashMap 储存新建的Node
    // 递归条件 ：
    // base case 当前node已存在于HashTable，返回HashMap中对应的clone
    // cond case 当前node不存在于HashTable，表示该Node未clone过，即构建一个新的对象放入HashMap，同时将旧对象
    //              放入HashTable，接着递归clone 邻居，将返回的Node加入List，最后返回当前构造的对象
    // 注：应当先将构造好的对象放入HashMap后在clone邻居，以避免内··循环发生
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null){
            return null;
        }
        HashSet<GraphNode> table = new HashSet<>();
        HashMap<Integer, GraphNode> map = new HashMap<>();
        return cloneNode(node, table, map);
    }

    public GraphNode cloneNode(GraphNode node, HashSet<GraphNode> table, HashMap<Integer, GraphNode> map){
        if(table.contains(node)){
            return map.get(node.val);
        }
        else {
            GraphNode cloned = new GraphNode(node.val);
            table.add(node);
            map.put(node.val, cloned);
            for(int i = 0; i < node.neighbors.size(); i++){
                cloned.neighbors.add(cloneNode(node.neighbors.get(i), table, map));
            }

            return cloned;

        }
    }



}