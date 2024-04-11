import java.util.* ;
import java.io.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        for(int i = 1 ; i < n ; i++){
            int left = prev1 + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2 + Math.abs(heights[i] - heights[i-2]);
            curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

}