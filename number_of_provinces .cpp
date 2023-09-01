class Solution {
public:
    void dfs(int node, vector<int> adj[], vector<int>& vis){
        vis[node] = 1;
        for(auto it : adj[node]){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        //first convert the adjencancy matrix to adjencancy list 
        int V = isConnected.size();
        vector<int> adj[V];
        int count = 0;
        vector<int> vis(V, 0);

        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }

        for(int i = 0; i<V ; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }
};