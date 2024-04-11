class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        int minDistance = INT_MAX;
        int index = 0;
        bool flag = false;
        for(int i = 0 ; i<points.size() ; i++){
            if(points[i][0] == x || points[i][1] == y){
                int dis = abs(points[i][0] - x) + abs(points[i][1] - y);
                flag = true;
                if(minDistance > dis){
                    minDistance = dis;
                    index = i;
                }
            }
        }
        return flag ? index : -1;
    }
};