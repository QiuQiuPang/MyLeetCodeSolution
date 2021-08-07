import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_1046 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Integer x,y;
        for(int i : stones){
            queue.add(i);
        }
        while(queue.size()>1){
            x = queue.remove();
            y = queue.remove();
            System.out.println(x);
            System.out.println(y);
            if(!x.equals(y)) queue.add(Math.abs(x-y));
        }
        return queue.remove();
    }
}
