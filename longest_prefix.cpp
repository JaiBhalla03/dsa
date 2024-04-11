class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.empty()){
            return "";
        }
        string prefix = strs[0];
        for(int i= 1;i<strs.size();i++){
            int j = 0;
            string current = strs[i];
            while(j < current.size() && j < prefix.size() && current[j] == prefix[j]){
                ++j;
            }
            prefix = prefix.substr(0, j);
        }
        return prefix;
    }
};