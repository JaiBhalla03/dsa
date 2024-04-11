class Solution {
public:
    string decodeString(string s) {
        string ans = "";
        stack<char> st;
        int n = s.size();
        for(int i = 0 ; i < n ; i++){
            if(s[i] == '[' || (s[i] >= 'a' && s[i] <= 'z') || (s[i] >= '0' && s[i] <= '9')){
                st.push(s[i]);
            }
            else{
                string temp = "";
                string temp1 = "";
                while(st.top() != '['){
                    temp = st.top() + temp;
                    st.pop();
                }
                st.pop();
                string num = "";
                while(!st.empty() && st.top() >= '0' && st.top() <= '9'){
                    num = st.top() + num;
                    st.pop();
                }
                int f = stoi(num);
                for(int i = 0 ; i < f ; i++){
                    temp1 += temp;
                }
                for(auto x : temp1){
                    st.push(x);
                }
            }
        }
        while(!st.empty()){
            ans = st.top() + ans;
            st.pop();
        }
        return ans;
    }
};