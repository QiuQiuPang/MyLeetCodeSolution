import java.util.*;

class Solution_684 {

    public static void main(String[] args) {
        Arrays.toString(new int[5]);
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{85,163},{37,148},{22,167},{60,114},{66,179},{53,118},{15,133},{52,70},{19,198},{147,184},{20,125},{76,153},{94,132},{98,127},{144,180},{2,109},{144,161},{89,197},{62,174},{81,149},{76,168},{36,197},{11,122},{140,145},{87,134},{131,154},{86,134},{3,80},{37,135},{36,163},{88,144},{24,109},{18,113},{57,115},{13,194},{9,104},{20,104},{36,78},{71,78},{59,174},{59,111},{107,192},{74,112},{85,190},{108,197},{21,157},{15,91},{74,130},{38,62},{127,145},{99,171},{115,168},{41,175},{75,168},{67,179},{21,68},{125,180},{63,124},{114,188},{17,69},{155,175},{61,196},{43,165},{10,189},{129,139},{152,174},{71,186},{86,146},{4,131},{7,193},{152,178},{77,160},{26,149},{92,179},{141,155},{121,164},{14,135},{28,70},{15,182},{85,177},{33,123},{10,30},{25,150},{19,105},{76,101},{45,58},{146,173},{79,96},{183,190},{40,124},{128,151},{142,153},{46,175},{50,156},{19,64},{64,174},{54,73},{67,114},{27,30},{12,110},{80,195},{48,184},{42,124},{99,102},{156,166},{150,199},{29,90},{106,166},{59,139},{44,67},{141,167},{81,123},{99,115},{19,100},{95,116},{21,97},{1,46},{55,73},{118,195},{148,151},{29,192},{47,98},{156,194},{32,133},{90,189},{18,101},{39,108},{35,58},{94,164},{24,129},{84,115},{113,147},{19,120},{15,187},{125,127},{23,118},{158,193},{6,93},{89,130},{51,190},{83,117},{46,181},{143,191},{11,165},{100,143},{9,122},{60,193},{49,83},{68,96},{5,37},{8,105},{124,126},{48,82},{46,116},{94,137},{147,159},{7,169},{56,74},{5,155},{103,185},{154,160},{56,185},{77,151},{79,132},{10,17},{53,65},{172,177},{31,136},{10,54},{7,165},{113,173},{47,119},{31,72},{93,144},{153,176},{31,123},{12,27},{94,199},{35,68},{102,200},{162,176},{94,170},{138,153},{15,102},{144,178},{106,151},{3,45},{70,149},{23,49},{81,196},{28,34},{21,61},{17,150},{40,154},{48,51},{78,192},{16,74},{116,158},{12,16},{13,34}})));
    }
    public static int[] findRedundantConnection(int[][] edges) {

        // convert the vertexes into graph structure
        // creat a graph
        HashMap<Integer,List<Integer>> graph= new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i=1; i<edges.length+1;i++){graph.put(i,new ArrayList<Integer>());}
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            if(dfs(graph,visited, 0, edge[0])){
                return edge;
            }
            visited.clear();
        }
        return null;
    }
    // prev indicate the previous node, it's used for avoid reverser visiting
    public static boolean dfs(HashMap<Integer, List<Integer>> graph, HashSet visited, Integer prev, Integer cur){
        if(visited.contains(cur)) return true;
        visited.add(cur);
        if(graph.get(cur).size()==0) return false;
        for(Integer next :graph.get(cur)){
            if(next!=prev){
                if(dfs(graph, visited, cur, next)) return true;
            }
        }
        return false;
    }

}

/*
*     public static int[] findRedundantConnection(int[][] edges) {
        // Assume there is only one cycle in the graph
        // Key Method: Find the cycle and break it can make a tree
        // Way of approach: use BFS finding the cycle
        // Step 1: Convert to Graph HasMap<Integer,Integer[]{Integer(des),Integer(traversed)}>
        // Problem : return last edge in the input;

        // Way2 of approach: store the values in the edge appeared in the edge array
        //                   if the des appeared already, it's a cycle

        // Step 1: create a array indicating if the node apeared
        int[] parent = new int[edges.length+1];
        // traverse all edges
        for(int[] edge: edges){
            int from = Math.min(edge[0],edge[1]), to = from==edge[0]?edge[1]:edge[0];
            // check if parent updated
            if(parent[from]!=0) parent[from] = needUpdate(parent, from);
            if(parent[to]!=0) parent[to] = needUpdate(parent,to);
            // base case: if both node have no parent yet or have same parent, their parents are the same
            // return case: if two nodes have same parent
            if(parent[from] == parent[to]) {
                if(parent[from] != 0) return edge;
                parent[from] = from;
                parent[to] = from;
            }
            // base case: if any one of them 0 and the other one not, update the no-parent node from the other one
            else if(parent[from] == 0 || parent[to]==0){
                if(parent[from]==0) parent[from] = parent[to];
                else parent[to] = parent[from];
            }
            // base case: if both node has parent and they are different
            else {
                if(parent[from]>parent[to]){
                    parent[parent[from]] = parent[to];
                    parent[from] = parent[to];
                }
                else{
                    parent[parent[to]] = parent[from];
                    parent[to] = parent[from];
                }
            }
        }
        return null;
    }

    public int needUpdate(int[] parent, int cur){
        if(parent[cur] == cur) return cur;
        else{
            return needUpdate(parent, parent[cur]);
        }
    }
* */