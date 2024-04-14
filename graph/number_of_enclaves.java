class Solution {
    public int dfs(int[][] grid, boolean[][] vis, int i, int j){
        if(vis[i][j] == true || grid[i][j] == 0) return 0;
        vis[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        count += 1;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n){
                count += dfs(grid, vis, newRow, newCol);
            }
        }
        return count;
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int num = 0;
        int ones = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) {
                    ones +=1;
                    if(i == 0 || i == m-1 || j == 0 || j == n-1){
                        num += dfs(grid, vis, i, j);
                    }
                }
            }
        }
        return ones - num;
    }
}