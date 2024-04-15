class Solution {

    static int longestSubsequence(int N, int A[]) {
        int ans = 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(Math.abs(A[i] - A[j]) == 1){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}