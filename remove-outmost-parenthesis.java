class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        String ans = "";
        String n = "";
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            st.push(ch);
            if(ch == '('){
                count++;
            }
            else{
                count--;
            }

            if(count == 0){
                st.pop();
                while(!st.isEmpty()){
                    char c = st.peek();
                    st.pop();
                    if(!st.isEmpty()){
                        n = c + n;
                    }
                }
                ans = ans + n;
                n = "";
            }

        }
        return ans;
    }
}