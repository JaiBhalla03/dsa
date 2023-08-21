class Solution {
public:

    int countBinarySubstrings(string s) {
        int count  =  0;
        int prev = 0 , curr = 1;
        for(int i=1  ;i<s.size() ; i++){
            if(s[i] == s[i-1]){
                curr++;
            }
            else{
                prev = curr;
                curr = 1;
            }
            if(prev >= curr) count++;
        }

        return count;
    }
};