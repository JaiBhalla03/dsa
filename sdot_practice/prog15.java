//import java.util.*;
//
///*
//Test Cases:
//Input
//1,2,3,1
//Output
//4
//Input
//2,7,9,3,1
//Output
//12
//* */
//public class prog15 {
//    public static int helper(int i, int[] houses, int[] dp){
//        if(i < 0){
//            return 0;
//        }
//        if(i == 0) return houses[i];
//        if(dp[i] != -1) return dp[i];
//        int stealing = houses[i] + helper(i-2, houses, dp);
//        int notStealing = helper(i-1, houses, dp);
//        return dp[i] = Math.max(stealing, notStealing);
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String[] values = sc.nextLine().split(",");
//        int[] houses = new int[values.length];
//        for(int i = 0 ; i < values.length ; i++){
//            houses[i] = Integer.parseInt(values[i]);
//        }
//        int n = houses.length;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        int ans = helper(n-1, houses, dp);
//        System.out.println(ans);
//    }
//}
