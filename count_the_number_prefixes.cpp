class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        int n = words.size();
        int count = 0;
        int c = 0;
        int i, j;
        for(i = 0 ; i<n ;i++){
            c = 0;
            for(j = 0 ; j<words[i].size(); j++){
                if(words[i][j] == s[j]){
                    c++;
                }
            }
            if(c == words[i].size()){
                count++;
            }
        }
        return count;
    }
};