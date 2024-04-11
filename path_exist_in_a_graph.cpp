class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        if(source ==  destination) return true;
        if(edges.size() == 0) return false;
        vector<int> adj[n];

        for(vector<int> edge : edges){
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        queue<int> q;
        q.push(source);
        vector<bool> vis(n ,false);
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(auto it : adj[node]){
                if(!vis[it]){
                    if(it == destination) return true;
                    q.push(it);
                    vis[it] = true;
                }
            }
        }
        return false;
    }
};