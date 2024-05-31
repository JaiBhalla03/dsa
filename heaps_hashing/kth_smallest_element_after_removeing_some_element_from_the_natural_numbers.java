/*package whatever //do not write package name here */
import java.util.*;
import java.io.*;

class GFG {
    public static List<Integer> helper(int[] arr, int k){
        int n = arr.length;
        boolean[] dont = new boolean[k+1+n];
        for(int x : arr){
            dont[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i < k+1+n ; i++){
            if(!dont[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;
        int arr[] = new int[n];
        for(int i =0 ; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int k = sc.nextInt();
        List<Integer> ans = helper(arr, k);
        for(int x : ans){
            System.out.print(x + " ");
        }
    }
}




