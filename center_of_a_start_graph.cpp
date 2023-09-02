class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int n = edges.size()+2;
        vector<int> adj[n];
        for(int i = 0 ; i<n-2 ; i++){
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        int count = 0;
        for(int i = 1 ; i<n ; i++){
            for(auto it : adj[i]){
                count ++;
            }
            if(count == n-2) return i;
            count = 0;
        }
        return 0;
    }
};