class Solution {
public:
    int commonFactors(int a, int b) {
        int small = (a >= b) ? b : a;
        int large = (a < b) ? b : a;
        int count = 0;
        vector<int> freq(large+1, 0);
        for(int i = 1 ; i <= small ; i++){
            if(small % i == 0){
                freq[i]++;
            }
        }
        for(int i = 1 ; i <= large ; i++){
            if(large % i == 0){
                freq[i]++;
            }
        }
        for(auto x : freq){
            if(x == 2){
                count++;
            }
        }
        return count;
    }
};