package Graphs.TraversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        int ans  = 0;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0) total++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int k = q.size();
            count += k;
            while(k-- > 0){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                if(r+1 < n && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    q.add(new int[]{r+1,c});
                }
                if(r-1 >= 0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    q.add(new int[]{r-1,c});
                }
                if(c+1 < m && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    q.add(new int[]{r,c+1});
                }
                if(c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    q.add(new int[]{r,c-1});
                }
            }
            if(!q.isEmpty()) ans++;
        }
        if(count == total) return ans;
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1} , {0, 1, 1} , {1, 0, 1}};
        System.out.println(orangesRotting(grid));
    }
}
