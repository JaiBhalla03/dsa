///*
//* 1-> The Longest valid parenthesis
//* 2-> infix to postfix
//* 3-> postfix evaluation
//* 4-> basic calculator
//* */
//
//
//import java.util.*;
//
//
//public class prog7 {
//    //helper function to know the precedence
//    public static int prec(char ch){
//        if(ch == '+' || ch == '-') return 1;
//        else if(ch == '*' || ch == '/') return 2;
//        else if(ch == '^') return 3;
//        return -1;
//    }
//    //function to perform the infix to postfix
//    public static String infixToPostfix(String str){
//        String n = "";
//        Stack<Character> st = new Stack<>();
//        for(int i = 0 ; i < str.length() ; i++){
//            char ch = str.charAt(i);
//            if(ch >= 'a' && ch <= 'z'){
//                n = n + ch;
//            }
//            else if(ch == '('){
//                st.push(ch);
//            }
//            else if(ch == ')'){
//                while(!st.isEmpty() && st.peek() != '('){
//                    n = n + st.pop();
//                }
//                st.pop();
//            }
//            else{
//                while(!st.isEmpty() && prec(st.peek()) >= prec(ch)){
//                    n = n + st.pop();
//                }
//                st.push(ch);
//            }
//        }
//        while(!st.isEmpty()){
//            n = n + st.pop();
//        }
//        return n;
//    }
//    //function that returns the length of the longest valid parenthesis
//    public static int longestValidParenthesis(String str){
//        int result = 0;
//        Stack<Integer> st = new Stack<>();
//        st.push(-1);
//        int n = str.length();
//        for(int i = 0 ; i < n ; i++){
//            if(str.charAt(i) == '('){
//                st.push(i);
//            }
//            else{
//                if(!st.isEmpty()){
//                    st.pop();
//                }
//            }
//            if(!st.isEmpty()){
//                result = Math.max(result, i - st.peek());
//            }
//            else{
//                st.push(i);
//            }
//        }
//        return result;
//    }
//
//    //function for the postfix evaluation
//    public static int evaluate(String str){
//        Stack<Integer> st = new Stack<>();
//        int n = str.length();
//        for(int i = 0 ; i < n ; i++){
//            char ch = str.charAt(i);
//            if(Character.isDigit(ch)) st.push(Integer.parseInt(String.valueOf(ch)));
//            else{
//                int b = st.pop();
//                int a = st.pop();
//                if(ch == '+') st.push(a + b);
//                if(ch == '-') st.push(a - b);
//                if(ch == '*') st.push(a * b);
//                if(ch == '/') st.push(a / b);
//            }
//        }
//        return st.pop();
//    }
//    //function to create a basic calculator
//    public static int basicCalculate(String str){
//        Stack<Integer> operands = new Stack<>();
//        Stack<Character> operator = new Stack<>();
//        int n = str.length();
//        for(int i = 0 ; i < n ; i++){
//            char ch = str.charAt(i);
//            if(Character.isDigit(ch)){
//                int num = ch - '0';
//                while(i + 1 < n && Character.isDigit(str.charAt(i+1))){
//                    num = num*10 + (str.charAt(i+1) - '0');
//                    i++;
//                }
//                operands.push(num);
//            }
//            else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
//                while(!operator.isEmpty() && prec(operator.peek()) >= prec(ch)){
//                    evaluateHelper(operands, operator);
//                }
//                operator.push(ch);
//            }
//        }
//        while(!operator.isEmpty()){
//            evaluateHelper(operands, operator);
//        }
//        return operands.pop();
//    }
//
//    public static void evaluateHelper(Stack<Integer> operands, Stack<Character> operator){
//        int b = operands.pop();
//        int a = operands.pop();
//        int op = operator.pop();
//        int result = 0;
//        if(op == '+') result = a + b;
//        if(op == '-') result = a - b;
//        if(op == '*') result = a * b;
//        if(op == '/') result = a / b;
//        operands.push(result);
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println(basicCalculate(str));
//    }
//}
