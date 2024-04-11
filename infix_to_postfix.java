class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int prec(char ch){
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        return -1;
    }
    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<Character>();
        String output = "";
        for(int i = 0 ; i < exp.length() ; i++){
            if((exp.charAt(i) >= 'a' && exp.charAt(i) <= 'z')
                    || (exp.charAt(i) >= '0' && exp.charAt(i) <= '9')){
                output += exp.charAt(i);
            }
            else if(exp.charAt(i) == '('){
                st.push(exp.charAt(i));
            }
            else if(exp.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    output += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && prec(st.peek()) >= prec(exp.charAt(i))){
                    output += st.pop();
                }
                st.push(exp.charAt(i));
            }

        }
        while(!st.isEmpty()){
            output += st.pop();
        }
        return output;
    }
}