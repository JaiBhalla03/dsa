class Solution {
    // Function to detect cycle in an undirected graph.
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public boolean helper(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int neighbour : adj.get(node)){
                if(vis[neighbour] == false){
                    vis[neighbour] = true;
                    q.add(new Pair(neighbour, node));
                }
                else if(neighbour != parent) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++) vis[i] = false;
        for(int i = 0 ; i < V ; i ++){
            if(vis[i] == false){
                if(helper(i, adj, vis)) return true;
            }
        }
        return false;
    }
}