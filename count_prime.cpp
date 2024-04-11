class Solution {
public:
    int countPrimes(int n) {
        int count = 0;
        if(n<=2){
            return 0;
        }
        vector<bool> flag(n ,false);
        int limit = static_cast<int>(sqrt(n))+1;
        for(int i = 2  ;i<limit ;i++){
            if(!flag[i]){
                for(long j = static_cast<long>(i)*i ; j<n;j+=i){
                    flag[j] = true;
                }
            }
        }
        for(int i = 2 ; i<flag.size(); i++){
            if(!flag[i]) count++;
        }
        return count;
    }
};