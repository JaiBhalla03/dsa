class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        int count = 0;
        int n = words.size();
        for(int i = 0 ; i < n; i++){
            int l = words[i].size();
            int c = 0;
            for(int j = 0 ; j < l ; j++){
                for(int k = 0; k<allowed.size() ; k++){
                    if(words[i][j] == allowed[k]){
                        c++;
                        break;
                    }
                }
                if(c == l) count++;
            }
        }
        return count;
    }
};