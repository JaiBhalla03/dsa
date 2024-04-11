class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        Dequeue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int x : adj.get(node)){
                if(vis[x] == false){
                    q.add(x);
                    vis[x] = true;
                }
            }
        }
        return bfs;
    }

}