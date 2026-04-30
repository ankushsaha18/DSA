package Graphs.Cycle;
import java.util.*;

public class DetectCycleBFS {
    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(0,1));
        adj[1].addAll(Arrays.asList(0, 2));
        adj[2].addAll(Arrays.asList(2, 3));
        System.out.println(isCycle(V,adj));
    }
    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                ans = bfs(i,adj,visited);
                if(ans){
                    break;
                }
            }
        }
        return ans;
    }
    public static boolean bfs(int i,List<Integer>[] adj,boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,-1});
        visited[i] = true;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for (int num : adj[node]) {
                if (!visited[num]) {
                    visited[num] = true;
                    q.add(new int[]{num, node});
                } else if (num != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
