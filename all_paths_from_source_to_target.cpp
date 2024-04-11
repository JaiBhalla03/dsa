class Solution {
public:
    void helper(vector<vector<int>> &ans, vector<vector<int>> graph, vector<int> temp, vector<int> vis, int start, int n){
        temp.push_back(start);
        if(start == n-1){
            ans.push_back(temp);
        }
        for(auto it : graph[start]){
            if(!vis[it]){
                vis[it] = true;
                helper(ans, graph, temp, vis, it, n);
                vis[it] = false;
            }
        }
        temp.pop_back();
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>> ans;
        vector<int> temp;
        int start = 0;
        int n = graph.size();
        vector<int> vis(n, 0);
        helper(ans, graph, temp, vis, start, n);
        return ans;
    }
};