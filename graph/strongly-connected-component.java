class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, it, st);
            }
        }
        st.push(node);
    }

    public void dfs1(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs1(adj, vis, it);
            }
        }
    }


    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[V];
        //sorting all the edges according to the finishing time
        for(int i = 0 ; i < V ; i++){
            if(vis[i] == 0){
                dfs(adj, vis, i, st);
            }
        }
        //reversing the edges of the graph
        ArrayList<ArrayList<Integer>> adjt = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adjt.add(new ArrayList<>());
        }

        for(int i = 0 ; i < V ; i++){
            vis[i] = 0;
            for(int it : adj.get(i)){
                adjt.get(it).add(i);
            }
        }
        //doing the dfs again
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                dfs1(adjt, vis, node);
                scc++;
            }
        }
        return scc;
    }
}