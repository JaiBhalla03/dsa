class Solution {
public:
    void dfs(vector<vector<int>>& ans, int color, int iniColor, int sr, int sc, vector<int> dRow, vector<int> dCol){
        ans[sr][sc] = color;
        int n = ans.size();
        int m = ans[0].size();
        for(int i = 0 ; i < 4 ; i++){
            int nRow = sr + dRow[i];
            int nCol = sc + dCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && ans[nRow][nCol] != color && ans[nRow][nCol] == iniColor){
                dfs(ans, color, iniColor, nRow, nCol, dRow, dCol);
            }
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        vector<vector<int>> ans = image;
        vector<int> dRow = {-1, 0, 1, 0};
        vector<int> dCol = {0, 1, 0, -1};
        dfs(ans, color, iniColor, sr, sc, dRow, dCol);
        return ans;
    }
};