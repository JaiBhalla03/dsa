class Solution {
    private boolean isCycle(int node, int[] vis, int[] pathvis, int[] check, int[][] graph){
        vis[node] = 1;
        pathvis[node] = 1;
        for(int x : graph[node]){
            if(vis[x] == 0) {
                if(isCycle(x, vis, pathvis, check, graph)) {return true;}
            }
            else if(pathvis[x] == 1) {return true;}
        }
        pathvis[node] = 0;
        check[node] = 1;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; // get the number of nodes
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] check = new int[n];
        List<Integer> ans = new ArrayList<>();
        //find all the nodes that have a that leads to a cycle
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0){
                isCycle(i, vis, pathvis, check, graph);
            }
        }
        for(int i = 0 ; i < check.length ; i++){
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
}