import java.util.*;

/*
Test Case
Input:
1
acbaa
Output:
5
* */

public class prog31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] track = new int[3];
        int left = 0;
        int res = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            track[s.charAt(i) - 'a']++;
            while(track[0] > 0 && track[1] > 0 && track[2] > 0){
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        System.out.println(res);
    }
}
