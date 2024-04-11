class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void helper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
        vis[node] = true;
        dfs.add(node);
        for(int x : adj.get(node)){
            if(vis[x] == false){
                helper(x, vis, adj, dfs);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        helper(0, vis, adj, dfs);
        return dfs;
    }
}