import java.util.*;

public class prog17 {
    public static int helper(int i, int w, int[] weights, int[] items, int[][] dp) {
        if(i == 0){
            if(w >= weights[0]) return items[0];
            else return 0;
        }
        if(dp[i][w] != -1) return dp[i][w];
        int notTake = helper(i - 1, w, weights, items, dp);
        int take = (int)(-1e9);
        if(w >= weights[i]){
            take = items[i] + helper(i-1, w-weights[i], weights, items, dp);
        }
        return dp[i][w] = Math.max(notTake, take);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of items
        int w = sc.nextInt(); // Knapsack capacity
        int[][] dp = new int[n + 1][w + 1]; // Memoization table

        // Initialize memoization table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Input item values and weights
        int[] items = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            items[i] = sc.nextInt();
        }

        // Calculate and print the maximum value
        int ans = helper(n - 1, w, weights, items, dp);
        System.out.println(ans);
    }
}
