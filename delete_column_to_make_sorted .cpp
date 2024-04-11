class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int result = 0;
        int n = strs.size();
        int len = strs[0].size();
        int i, k=  0, flag;
        while(k < len){
            flag = 0;
            for(i = 0 ; i < n-1 ;i++){
                if(strs[i][k] > strs[i+1][k]){
                    flag = 1;
                }
            }
            k++;
            if(flag == 1){
                result++;
            }
        }
        return result;
    }
};