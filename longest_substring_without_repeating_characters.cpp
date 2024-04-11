class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen = 0;
        int i = 0, j = 0;
        unordered_set<char> charSet;
        while(j < s.size()){
            if(charSet.find(s[j]) == charSet.end()){
                charSet.insert(s[j]);
                maxLen = max(maxLen, j - i + 1);
                j++;
            }
            else{
                charSet.erase(s[i]);
                i++;
            }
        }
        return maxLen;
    }
};