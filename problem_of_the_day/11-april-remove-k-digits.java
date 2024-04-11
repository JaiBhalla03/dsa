class Solution {
    public String removeKdigits(String num, int k) {
        //if(num.length() == k) return "0";
        Stack<Character> st = new Stack<Character>();
        for(int i = 0 ; i < num.length() ; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }

        str.reverse();
        while(str.length() > 0 && str.charAt(0) == '0'){
            str.deleteCharAt(0);
        }
        return str.length() > 0 ? str.toString() : "0";
    }
}