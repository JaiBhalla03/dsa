class Solution {
public:
    string longestPalin (string S) {
        int maxLen = 1;
        int start = 0;
        int n = S.size();
        for(int i = 0  ; i < n ; i++){
            //if the palindrome is of odd length
            int left=i;int right = i;
            while(left >= 0 && right < n && S[left] == S[right]){
                if(maxLen < right - left +1){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
            //if the palindrome is of even length
            left = i; right = i+1;
            while(left >= 0 && right < n && S[left] == S[right]){
                if(maxLen < right - left + 1){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return S.substr(start, maxLen);
    }
};
