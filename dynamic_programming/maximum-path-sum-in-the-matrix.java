import java.util.* ;
import java.io.*;

public class Solution {
    public static int helper(int i, int j, int m, int n, int[][] matrix, int[][] dp){
        if(j < 0 || j >= n) return (int)(-1e9);
        if(i == 0) return matrix[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + helper(i-1, j, m, n, matrix, dp);
        int leftD = matrix[i][j] + helper(i-1, j-1, m, n, matrix, dp);
        int rightD = matrix[i][j] + helper(i-1, j+1, m, n, matrix, dp);
        return Math.max(up, Math.max(leftD, rightD));
    }
    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = (int)(-1e9);
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, helper(m-1, i, m, n, matrix, dp));
        }
        return ans;
    }
}
