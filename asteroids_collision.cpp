class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> ans;
        stack<int> st;
        for(int i = 0 ; i < asteroids.size(); i ++){
            if(st.empty() ||
               (st.top() < 0 && asteroids[i] > 0) ||
               (signbit(st.top()) == signbit(asteroids[i]))
                    ){
                st.push(asteroids[i]);
            }
            else{
                if(abs(st.top()) == abs(asteroids[i])) st.pop();
                else if(abs(st.top()) < abs(asteroids[i])){
                    while(!st.empty() && abs(st.top()) < abs(asteroids[i]) && st.top() > 0){
                        st.pop();
                    }
                    if(st.empty() ||
                       signbit(st.top()) == signbit(asteroids[i])) st.push(asteroids[i]);
                    else if(st.top() + asteroids[i] == 0) st.pop();
                }
            }
        }
        while(!st.empty()){
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};