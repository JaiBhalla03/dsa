import java.util.*;

/*
Example 1:
Input: nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
Output: 2

Example 2:
Input: nums = [4,3,6], numsDivide = [8,2,6,10]
Output: -1
* */

public class prog22 {
    public static int GCD(int a, int b){
        if(a%b == 0) return b;
        return GCD(b, a%b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] values1 = sc.nextLine().split(" ");
        String[] values2 = sc.nextLine().split(" ");
        int[] nums = new int[values1.length];
        int[] numsDivide = new int[values2.length];
        for(int i = 0 ; i < values1.length ; i++){
            nums[i] = Integer.parseInt(values1[i]);
        }
        for(int i = 0 ; i < values2.length ; i++){
            numsDivide[i] = Integer.parseInt(values2[i]);
        }
        int divisor = numsDivide[0];
        for(int i = 1 ; i < numsDivide.length ; i++){
            divisor = GCD(divisor, numsDivide[i]);
        }

        int deletions = 0;
        boolean flag = false;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < divisor) deletions++;
            if(nums[i] == divisor) flag = true;
        }
        if(flag){
            System.out.println(deletions);
        }
        else{
            System.out.println(-1);
        }
    }
}
