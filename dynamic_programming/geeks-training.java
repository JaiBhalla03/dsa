//memoization
class Solution{
    public int helper(int day, int last, int[][] points, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i <= 2 ; i++){
                if(i != last){
                    maxi = Math.max(maxi, points[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i = 0 ; i <= 2 ; i++){
            if(i != last){
                int point = points[day][i] + helper(day-1, i, points, dp);
                maxi = Math.max(point, maxi);
            }
        }
        return dp[day][last] = maxi;
    }
    public int maximumPoints(int points[][],int N){
        int day = N - 1;
        int last = 3;
        int[][] dp = new int[N+1][4];
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j < 4 ; j ++) dp[i][j] = -1;
        }
        int ans = helper(day, last, points, dp);
        return ans;
    }
}

//tabulation
