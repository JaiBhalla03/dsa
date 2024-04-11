class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int totalProfit = 0;
        int i;
        for(i = 1 ; i < prices.size() ; i++){
            if(prices[i-1] < prices[i]){
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }
};