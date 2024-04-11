class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        unordered_map<int, int> freq;
        for(int i = lowLimit ; i <= highLimit ; i++){
            int p = i;
            int s = 0;
            while(p != 0){
                int d = p%10;
                p=p/10;
                s+=d;
            }
            freq[s]++;
        }
        int maxF = INT_MIN;
        for(auto x : freq){
            maxF = max(maxF, x.second);
        }
        return maxF;
    }
};