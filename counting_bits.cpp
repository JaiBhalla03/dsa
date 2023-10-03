class Solution {
public:
    int ones(int i){
        int count = 0;
        while(i != 0){
            int m = i%2;
            if(m == 1) count++;
            i/=2;
        }
        return count;
    }
    vector<int> countBits(int n) {
        vector<int> ans;
        for(int i = 0 ; i <= n ; i++){
            ans.push_back(ones(i));
        }
        return ans;
    }
};