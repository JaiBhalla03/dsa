import java.util.*;

/*
Test Case 1
Input:-
23
Output:-
ad ae af bd be bf cd ce cf

Test Case 2
Input:-
234
Output:-
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg
cdh cdi ceg ceh cei cfg cfh cfi

* */

public class prog29 {
    public static String[] keypad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void calculate(int index, String digits, StringBuilder helper, List<String> ans){
        if(index == digits.length()){
            ans.add(helper.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        for(int i = 0 ; i < keypad[num].length() ; i++){
            helper.append(keypad[num].charAt(i));
            calculate(index + 1, digits, helper, ans);
            helper.deleteCharAt(helper.length() - 1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();

        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return;
        StringBuilder helper = new StringBuilder();
        calculate(0, digits, helper, ans);
        for(String s : ans){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
