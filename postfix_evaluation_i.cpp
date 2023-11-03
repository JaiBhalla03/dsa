class Solution
{
public:
    //Function to evaluate a postfix expression.
    int evaluatePostfix(string S) {
        stack<int> st;
        for (int i = 0; i < S.size(); i++) {
            if (S[i] >= '0' && S[i] <= '9') {
                st.push(S[i] - '0'); // Convert char to integer and push it onto the stack
            }
            else {
                int b = st.top();
                st.pop();
                int a = st.top();
                st.pop();
                if (S[i] == '+') st.push(a + b);
                else if (S[i] == '-') st.push(a - b);
                else if (S[i] == '*') st.push(a * b);
                else if (S[i] == '/') st.push(a / b);
            }
        }
        return st.top();
    }

};