class Solution {
public:
    int strStr(string haystack, string needle) {
        int i;
        int n = haystack.size();
        for(i = 0;i<n;i++){
            if(haystack.substr(i, needle.size()) == needle){
                return i;
            }
        }
        return -1;
    }
};