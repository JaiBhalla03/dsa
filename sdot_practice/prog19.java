/*
Test Cases:
Input:-
10,22,9,33,21,50,41,60,80
Output:-
6

Input:-
3,10,2,1,20
Output:-
3

* */

import java.util.*;
public class prog19 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(",");
        int[] arr = new int[values.length];
        for(int i = 0 ; i < values.length ; i++){
            arr[i] = Integer.parseInt(values[i]);
        }
        int n = arr.length;
        int maxi = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev ++){
                if(arr[prev] < arr[i]){
                    if(dp[prev] + 1 > dp[i]){
                        cnt[i] = cnt[prev];
                        dp[i] = 1 + dp[prev];
                    }
                    else if(dp[prev] + 1 == dp[i]){
                        cnt[i] += cnt[prev];
                    }
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int los = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] == maxi){
                los += cnt[i];
            }
        }
        System.out.println(los);
    }
}
