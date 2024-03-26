import java.util.*;

public class prog12 {
    public static void dfs(int index, List<List<Integer>> adj, boolean[] visited){
        visited[index] = true;
        System.out.print(index + " ");
        for(Integer it : adj.get(index)){
            if(!visited[it]){
                dfs(it, adj, visited);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[E][2];
        for(int[] edge : edges){
            edge[0] = sc.nextInt();
            edge[1] = sc.nextInt();
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < E ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        int n = sc.nextInt();
        dfs(n, adj, visited);
    }
}
