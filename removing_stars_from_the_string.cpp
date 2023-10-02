class Solution {
public:
    string removeStars(string s) {
        stack<char> st;
        for(int i = 0 ; i < s.size() ; i++){
            if(s[i] == '*'){
                st.pop();
            }
            else{
                st.push(s[i]);
            }
        }
        string newStr = "";
        while(!st.empty()){
            newStr = st.top() + newStr;
            st.pop();
        }
        return newStr;
    }
};

//a more effiecient method will be
class Solution {
public:
    string removeStars(string s) {
        string ans;
        int i = 0;
        while(i < s.size()){
            if(s[i] == '*' && !ans.empty()){
                ans.pop_back();
            }
            else{
                ans.push_back(s[i]);
            }
            i++;
        }
        return ans;
    }
};