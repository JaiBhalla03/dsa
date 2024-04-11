/*
Test Cases:
Input:-
3 0 2 0 4
Output:-
7
Input:-
1 0 2 1 0 1
Output:-
2
* */
import java.util.*;

public class prog18 {
    public static int water(int[] blocks, int n){
        int res = 0;
        int l = 0;
        int r = n-1;
        int leftMax = blocks[l];
        int rightMax = blocks[r];
        while(l < r){
            if(leftMax < rightMax){
                l += 1;
                leftMax = Math.max(leftMax, blocks[l]);
                res += leftMax - blocks[l];
            }
            else{
                r -= 1;
                rightMax = Math.max(rightMax, blocks[r]);
                res += rightMax - blocks[r];
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        int[] blocks = new int[values.length];
        for(int i = 0 ; i < values.length ; i++){
            blocks[i] = Integer.parseInt(values[i]);
        }
        int n = blocks.length;
        int w = water(blocks, n);
        System.out.println(w);
    }
}
