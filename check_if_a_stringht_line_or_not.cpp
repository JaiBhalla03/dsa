class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        if(coordinates.size() <= 2){
            return true;
        }
        int xdiff = coordinates[1][0] - coordinates[0][0];
        int ydiff = coordinates[1][1] - coordinates[0][1];
        for(int i = 1 ; i < coordinates.size()-1 ; i++){
            int x = coordinates[i+1][0] - coordinates[i][0];
            int y = coordinates[i+1][1] - coordinates[i][1];
            if(x*ydiff != y*xdiff){
                return false;
            }
        }
        return true;
    }
};