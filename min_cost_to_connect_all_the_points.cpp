class Solution {
public:
    int dis(vector<int> p1, vector<int> p2){
        return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1]);
    }
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        vector<int> vis(n, 0);
        vector<int> minCost(n, INT_MAX);
        int currPoint = 0;
        minCost[0]=0;
        int ans = 0;
        while(currPoint >= 0){
            vis[currPoint] = 1;
            int nextPoint = -1;
            int minCurrCost = INT_MAX;
            for(int point = 0 ; point < n ; point ++){
                if(vis[point] || currPoint == point){
                    continue;
                }
                minCost[point] = min(dis(points[currPoint], points[point]), minCost[point]);
                if(minCost[point] < minCurrCost){
                    minCurrCost = minCost[point];
                    nextPoint = point;
                }
            }
            if(minCurrCost == INT_MAX){
                ans += 0;
            }
            else{
                ans += minCurrCost;
            }
            currPoint = nextPoint;
        }
        return ans;
    }
};