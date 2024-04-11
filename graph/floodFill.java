class Solution {
    public void helper(int[][] ans, int color, int iniColor, int sr, int sc, int[] delRow, int[] delCol){
        ans[sr][sc] = color;
        int n = ans.length;
        int m = ans[0].length;
        for(int i = 0 ; i < 4 ; i++){
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && ans[nRow][nCol] == iniColor && ans[nRow][nCol] != color){
                helper(ans, color, iniColor, nRow, nCol, delRow, delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int iniColor = image[sr][sc];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        helper(ans, color, iniColor, sr, sc, delRow, delCol);
        return ans;
    }
}