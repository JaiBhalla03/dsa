class Solution {
public:
    int checkRedundancy(string s) {
        stack<char> st;
        for(char c : s){
            if(c == ')'){
                char top = st.top();
                st.pop();
                int elementInside = 0;
                while(top != '('){
                    elementInside ++;
                    top = st.top();
                    st.pop();
                }
                if(elementInside <= 1){
                    return 1;
                }
            }
            else{
                st.push(c);
            }
        }
        return 0;
    }
};