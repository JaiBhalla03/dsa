class Solution {
public:
    void dfs(vector<int> adj[], vector<bool> &visited, int curr){
        visited[curr] = true;
        for(auto it : adj[curr]){
            if(visited[it] == false){
                dfs(adj, visited, it);
            }
        }
    }
    int makeConnected(int n, vector<vector<int>>& connections) {
        vector<int> adj[n];
        vector<bool> visited(n , false);
        int edge = 0;
        for(auto v : connections){
            adj[v[0]].push_back(v[1]);
            adj[v[1]].push_back(v[0]);
            edge++;
        }

        if(edge < n-1) return -1;

        int components=0;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                components+=1;
                dfs(adj, visited, i);
            }
        }
        int red = edge - (n-1 - (components - 1));
        if(red >= components-1){
            return components-1;
        }
        return -1;
    }
};

