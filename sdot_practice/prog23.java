import java.util.*;
/*
Example 1
Input
horse
ros
Output
3

Example 2
Input
intention
execution
Output
5
* */

public class prog23 {
    public static int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = helper(s1, s2, i-1, j-1, dp);
        if(dp[i][j] != -1) return dp[i][j];
        int insert = 1 + helper(s1, s2, i , j-1, dp);
        int delete = 1 + helper(s1, s2, i-1, j, dp);
        int replace = 1 + helper(s1, s2, i-1, j-1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = helper(s1, s2, m-1, n-1, dp);
        System.out.println(ans);
    }
}
