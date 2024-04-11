class Solution {
    public int helper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i == triangle.size() - 1 && j < triangle.get(triangle.size()-1).size()) return triangle.get(i).get(j);
        if(i > triangle.size() || j >= triangle.get(triangle.size() - 1).size()) return (int)(1e9);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + helper(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + helper(i+1, j+1, triangle, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for(int i = 0 ; i <= triangle.size() ; i++){
            for(int j = 0 ; j <= triangle.size() ; j++){
                dp[i][j] = -1;
            }
        }

        int ans = helper(0, 0, triangle, dp);

        return ans;
    }
}