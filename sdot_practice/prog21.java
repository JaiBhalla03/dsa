import java.util.*;

/*
Example 1:
Input: "race"
Output: "ecarace"
Explanation: By adding "eca" in front of "race," we get the shortest palindrome "ecarace."
Example 2:
Input: "abc"
Output: "cbabc"
Explanation: By adding "cb" in front of "abc," we get the shortest palindrome "cbabc."
Example 3:
Input: "level"
Output: "level"
Explanation: The given string "level" is already a palindrome, so no additional characters are
needed.
* */

public class prog21 {
    public static String shortestPalindrome(String str){
        String t = new StringBuilder(str).reverse().toString();
        int n = str.length();
        for(int i = 0  ; i < n ; i ++){
            if(str.startsWith(t.substring(i))){
                return t.substring(0, i) + str;
            }
        }
        return t + str;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = shortestPalindrome(str);
        System.out.println(ans);
    }
}
