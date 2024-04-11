import java.util.*;

/*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Input: "cbbd"
Output: "bb
* */

public class prog25 {
    public static String helper(String s){
        int n = s.length();
        int maxlen = 1;
        int start = 0;
        for(int i = 0 ; i < n ; i++){
            //if the palindrome is odd
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(maxlen < right-left+1){
                    maxlen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
            //if the palidrome is even
            left = i;
            right = i+1;
            while(left >= 0 && right < n && s.charAt(right) == s.charAt(left)){
                if(maxlen < right - left + 1){
                    maxlen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxlen);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = helper(s);
        System.out.println(ans);
    }
}
