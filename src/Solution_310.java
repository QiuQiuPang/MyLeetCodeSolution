import java.util.*;

public class Solution_310 {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return new ArrayList(Arrays.asList(0));

        List<Set<Integer>> edgeTable = new ArrayList<>(n);
        for(int i = 0; i<n; i++) edgeTable.add(new HashSet<Integer>());
        for(int[] edge: edges){
            edgeTable.get(edge[0]).add(edge[1]);
            edgeTable.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList();
        for(int i = 0; i<n; ++i) if(edgeTable.get(i).size() == 1) leaves.add(i);

        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList();
            for(Integer leaf : leaves){
                // iterator.next 返还这个set的key，因为没有其他办法access keyValue？
                Integer edgeEnd = edgeTable.get(leaf).iterator().next();
                edgeTable.get(edgeEnd).remove(leaf);
                if(edgeTable.get(edgeEnd).size()==1){
                    newLeaves.add(edgeEnd);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }


}
/*

class Solution {
    int N, sho;
    int[] mhe, sta, nei;
    List<Integer> ans=new ArrayList<>();

    int goh(int pr, int v) {
        int re=0;
        for (int i=sta[v]; i<sta[v+1]; i++) {
            int w=nei[i];
            if (w!=pr)
                re=Math.max(re, goh(v,w)+1);
        }
        //System.out.println(String.format("   mhe[%d] = %d", v, re));
        return mhe[v]=re;
    }

    void gox(int pr, int v, int uh) {
        int he=-8, h2=-8, tn=-1;
        for (int i=sta[v]; i<sta[v+1]; i++) {
            int w=nei[i], h=mhe[w];
            if (w!=pr) {
                if (h>he) {
                    tn=w;
                    h2=he;
                    he=h;
                } else if (h>h2)
                    h2=h;
            }
        }

        int maxh=Math.max(he+1, uh);
        //System.out.println(String.format("   gox v=%d he=%d h2=%d, tn=%d uh=%d maxh=%d", v, he, h2, tn, uh, maxh));
        if (maxh<=sho) {
            if (maxh<sho) {
                ans.clear();
                sho=maxh;
            }
            ans.add(v);
        }
        if (he>=uh && tn>=0)
            gox(v,tn,Math.max(uh+1,h2+2));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //System.out.println("------ case N="+n);
        N=n;
        if (N==1)
            return Arrays.asList(0);
        sho=N+10;
        int[] cnt = new int[N];
        mhe = new int[N];
        sta = new int[N+1];

        for (int[] p: edges) {
            ++cnt[p[0]];
            ++cnt[p[1]];
        }

        int f=0;
        for (int i=0; i<N; i++) {
            f += cnt[i];
            sta[i]=f;
        }
        sta[N]=f;

        nei=new int[f];
        for (int[] p: edges) {
            int a=p[0], b=p[1];
            nei[--sta[a]]=b;
            nei[--sta[b]]=a;
        }

        goh(-1,0);
        gox(-1,0,0);
        //System.out.println(ans.toString());
        return ans;
    }
}

 */