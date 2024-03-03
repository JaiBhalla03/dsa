import java.util.* ;
import java.io.*;
public class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(int x : adj.get(node)){
            if(vis[x] == false){
                dfs(x, adj, vis);
            }
        }
    }
    public static boolean helper(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis ){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int neighbour : adj.get(node)){
                if(vis[neighbour] == false){
                    vis[neighbour] = true;
                    q.add(new Pair(neighbour, node));
                }
                else if(parent != neighbour){
                    return true;
                }
            }
        }
        return false;
    }
    public static Boolean checkGraph(int[][] edges, int n, int m) {
        //creating the adjacency list from the given edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=  0  ;i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        boolean[] vis1 = new boolean[n];
        dfs(0, adj, vis);
        for(boolean tf : vis){
            if(tf == false) return false;
        }

        for(int i = 0  ; i < n ; i++){
            if(vis1[i] == false){
                if(helper(i, adj, vis1) == true) return false;
            }
        }
        return true;
    }
}