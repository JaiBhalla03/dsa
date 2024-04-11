class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> flag(n, 0);
        for(int i = 0 ; i < trust.size() ; i++){
            flag[trust[i][0] - 1]++;
        }
        int count = 0;
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            if(flag[i] == 0){
                count++;
                index = i+1;
            }
        }
        bool t = true;
        vector<int> check(n ,0);
        for(int i = 0 ; i<trust.size() ; i++){
            if(trust[i][1] == index){
                check[trust[i][0] - 1]++;
            }
        }
        for(int i = 0; i<n; i++){
            if(check[i] == 0 && i!=index-1){
                t = false;
            }
        }
        return t && (count == 1) ? index : -1;
    }
};