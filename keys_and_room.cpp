class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> vis(n, false);
        queue<int> q;
        q.push(0);
        vis[0] = true;
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(auto it : rooms[node]){
                if(!vis[it]){
                    vis[it] = true;
                    q.push(it);
                }
            }
        }
        for(auto it : vis){
            if(!it){
                return false;
            }
        }
        return true;
    }
};