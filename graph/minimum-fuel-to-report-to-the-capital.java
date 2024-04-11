class Solution {
    long ans = 0;
    public long dfs(int i, int[] vis, List<List<Integer>> adj, int seats){
        vis[i] = 1;
        long cnt = 1;
        for(int it : adj.get(i)){
            if(vis[it] == 0){
                cnt += dfs(it, vis, adj, seats);
            }
        }
        if(i != 0){
            ans += (long) Math.ceil((double) cnt/ seats);
        }
        return cnt;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int E = roads.length;
        if(E == 0) return 0;
        int V = E + 1;
        List<List<Integer>> adj = new ArrayList<>();
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int[] edge : roads){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0, vis, adj, seats);
        return ans;
    }
}