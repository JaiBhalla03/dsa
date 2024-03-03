class Solution {
    public void dfs(int node, List<List<Integer>> adj, int[] visited){
        visited[node] = 1;
        for(int it : adj.get(node)){
            if(visited[it] == 0){
                dfs(it, adj, visited);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        //creating an adjencancy list from the connections 2D array
        List<List<Integer>> adj = new ArrayList<>();
        int num = connections.length;
        if(n - 1 > num) return -1;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0){
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans-1;
    }
}