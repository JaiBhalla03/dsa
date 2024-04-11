import java.util.*;

/*
Example 1
Input
xyzxyzyy
Output
3
Explanation
The answer is "xyz ", with the length of 3
xxxxxxx
1
* */

public class prog20 {
    public static int longestSubstringWithoutRepeating(String str){
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int n = str.length();
        HashSet<Character> set = new HashSet<>();
        while(j < n){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            else{
                set.remove(str.charAt(j));
                i++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = longestSubstringWithoutRepeating(str);
        System.out.println(ans);
    }
}
