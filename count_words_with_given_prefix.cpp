class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int n = words.size();
        int count = 0;
        bool flag;
        for(int i = 0 ; i<n ; i++){
            flag = true;
            if(words[i].size() >= pref.size()){
                for(int j = 0 ; j < pref.size() ; j++){
                    if(pref[j] != words[i][j]){
                        flag = false;
                    }
                }
                if(flag){
                    count++;
                }
            }
            else{
                continue;
            }
        }
        return count;
    }
};