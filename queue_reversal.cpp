class Solution
{
public:
    queue<int> rev(queue<int> q)
    {
        stack<int> st;
        queue<int> ans;
        while(!q.empty()){
            st.push(q.front());
            q.pop();
        }
        while(!st.empty()){
            ans.push(st.top());
            st.pop();
        }
        return ans;
    }
};
