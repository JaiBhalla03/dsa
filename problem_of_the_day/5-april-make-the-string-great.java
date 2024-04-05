class Solution {
    public String makeGood(String s) {
        int n = s.length();
        if(n <= 1) return s;
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && (ch == st.peek() - 32 || ch == st.peek() + 32)){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}