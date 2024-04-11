import java.util.*;

/*
The pattern "h*t" matches strings like "hat," "hot," "hut," etc.
The pattern "c?t" matches strings like "cat," "cot," "cut," etc.
The pattern "ab*d" matches strings like "abd," "abcd," "abbd," etc.
* */

public class prog24 {
    public static boolean helper(String p, String s, int i, int j, int[][] dp){
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0) {
            for(int k = 0 ; k <= i ; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean result = false;
        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') result = helper(p, s, i-1, j-1, dp);
        else if(p.charAt(i) == '*') result = helper(p, s, i-1, j, dp) || helper(p, s, i, j-1, dp);
        dp[i][j] = result ? 1 : 0;
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String s = sc.nextLine();
        int m = p.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        boolean ans = helper(p, s, m-1, n-1, dp);
        System.out.println(ans);
    }
}
