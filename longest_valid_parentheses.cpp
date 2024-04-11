class Solution {
public:
    int longestValidParentheses(string s) {
        int left = 0 ;
        int right = 0;
        int maxLength = 0;
        int n = s.size();
        // moving from left to right
        for(int i = 0 ; i < n ; i++){
            if(s[i] == '(') left ++;
            else right ++;
            if(left == right) maxLength = max(maxLength, 2*right);
            else if(left < right) left = right = 0;
        }
        left = right = 0;
        //moving from right to left 
        for(int i = n-1 ; i >= 0 ; i--){
            if(s[i] == '(') left++;
            else right++;
            if(left == right) maxLength = max(maxLength, 2*right);
            else if(left > right) left = right = 0;
        }
        return maxLength;
    }
};