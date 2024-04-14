class Solution {
    public boolean reachedPacific = false;
    public boolean reachedAtlantic = false;
    public void dfs(int[][] heights, boolean[][] vis, int i, int j){
        int m = heights.length;
        int n = heights[0].length;
        vis[i][j] = true;
        if(i == 0 || j == 0) reachedPacific = true;
        if(i == m-1 || j == n-1) reachedAtlantic = true;
        if(reachedPacific && reachedAtlantic) return;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && heights[newRow][newCol] <= heights[i][j] && vis[newRow][newCol] == false){
                vis[newRow][newCol] = true;
                dfs(heights, vis, newRow, newCol);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                // if(vis[i][j] == false){
                boolean[][] vis = new boolean[m][n];
                reachedPacific = false;
                reachedAtlantic = false;
                dfs(heights, vis,  i , j);
                if(reachedPacific && reachedAtlantic){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    ans.add(arr);
                }
                // }
            }
        }
        return ans;
    }
}