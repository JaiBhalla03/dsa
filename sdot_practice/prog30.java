import java.util.*;
/*
Test Cases
Input:-
3
Output:-
((()))
(()())
(())()
()(())
()()()
* */
public class prog30 {
    public static void helper(List<String> ans, String s, int left, int right, int n){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }
        if(left < n){
            helper(ans, s + "(", left + 1, right, n);
        }
        if(right < left){
            helper(ans, s + ")", left, right + 1, n);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);
        for(String s : ans){
            System.out.println(s);
        }
    }
}
