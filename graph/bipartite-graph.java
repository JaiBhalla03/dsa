class Solution
{
    public boolean check(ArrayList<ArrayList<Integer>> adj, int[] color, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int it : adj.get(n)){
                if(color[it] == -1){
                    color[it] = 1 - color[n];
                    q.add(it);
                }
                else if(color[it] == color[n]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        //creating the color array that also acts as a visited array
        int[] color = new int[V];
        for(int i = 0 ; i < V ; i++) color[i] = -1;
        for(int i = 0 ; i<V ; i++){
            if(color[i] == -1){
                if(check(adj, color, i) == false) return false;
            }
        }
        return true;
    }
}