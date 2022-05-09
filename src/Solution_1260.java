import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_1260 {

    public static void main(String[] args) {
        System.out.println(shiftGrid(new int[][]{{1}}, 8));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int height = grid.length, width = grid[0].length, total = height * width;
        int[] flat =  new int[total];
        flat.hashCode();
        for(int i = 0; i < total ; i++){
            flat[i] = grid[i/width][i%width];
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int y = 0; y < height; y++){
            result.add(new ArrayList<>());
            for(int x = 0; x < width; x++){
                result.get(y).add(flat[(x+y*width-k+total)%total]);
            }
        }
        return result;
    }

}
