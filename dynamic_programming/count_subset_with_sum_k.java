import java.util.*;
import java.io.*;

public class Solution {
    public static int helper(int i, int[] nums, int target, int[][] dp){
        if(target == 0) return 1;
        if(i == 0) return target == nums[i] ? 1 : 0;
        if(dp[i][target] != -1) return dp[i][target];
        int notTake = helper(i-1, nums, target, dp);
        int take = 0;
        if(target >= nums[i]) take = helper(i-1, nums, target-nums[i], dp);
        return dp[i][target] =  notTake + take;
    }
    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length + 1][tar + 1];
        for(int i = 0  ;  i <= num.length ; i++){
            for(int j = 0 ; j <= tar ; j++){
                dp[i][j] = -1;
            }
        }
        int n = num.length;
        int ans = helper(n-1, num, tar, dp);
        return ans;
    }
}