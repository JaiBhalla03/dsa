class Solution {
public:
    int toInt(char c){
        return c-'a';
    }
    string oddString(vector<string>& words) {
        vector<vector<int>> result;
        // vector<int> check;

        for(int i =0 ; i<words.size() ;i++){
            vector<int> temp;
            for(int j = 0; j<words[i].size()-1; j++){
                int x = toInt(words[i][j+1]) - toInt(words[i][j]);
                temp.push_back(x);
            }
            result.push_back(temp);
        }
        set<vector<int>> myset(result.begin(), result.end());
        int count = 0;
        vector<int> temp;
        for (int i = 0; i < result.size(); i++) {
            if (result[i] == *myset.begin()) count++;
        }
        if (count == 1) {
            temp = *myset.begin();
        } else {
            auto it = myset.begin();
            it++;
            temp = *it;
        }
        int index = 0;
        for(int i = 0; i <result.size() ; i++){
            if(result[i] == temp) index = i;
        }
        return words[index];
    }
};