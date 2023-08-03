//brute force

class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> result;
        int n = groupSizes.size();
        int k;
        vector<bool> flag(n, false);
        for(int i = 0 ; i<n ; i++){
            vector<int> current;
            k = 0;
            for(int j = 0 ; j < n ; j++){
                if(k == groupSizes[i]){
                    break;
                }
                if(groupSizes[j] == groupSizes[i] && !flag[j]){
                    current.push_back(j);
                    flag[j] = true;
                    k++;
                }
            }
            if(current.size() > 0){
                result.push_back(current);
                current.clear();
            }
        }
        return result;
    }
};


//efficient approach

