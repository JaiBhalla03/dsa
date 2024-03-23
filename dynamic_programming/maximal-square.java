class Solution {
    public boolean isSquare(int n){
        double x = Math.sqrt(n);
        return x == Math.ceil(x);
    }
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // for(int i = 0 ; i < n ; i++){
        //     ans = Math.max(ans, helper(matrix, 0, i));
        // }
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    int rowBack =dp[i-1][j];
                    int colBack =dp[i][j-1];
                    dp[i][j]=1;
                    if(colBack>0){
                        dp[i][j]=colBack+rowBack;
                    }
                    else if(rowBack>0){
                        dp[i][j]=rowBack+1;
                    }
                    if(ans<dp[i][j]&&isSquare(dp[i][j])){
                        ans=dp[i][j];
                    }
                }
            }
        }
        for(int[] x : dp){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        return ans;
    }
}