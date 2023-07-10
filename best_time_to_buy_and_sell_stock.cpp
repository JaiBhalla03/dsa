class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = prices[0];
        int n = prices.size();
        int max_profit = 0;
        for(int i = 1 ; i<n;i++){
            //first find the lowest sell price
            if(buy > prices[i]){
                buy = prices[i];
            }
            else if(prices[i] - buy > max_profit){
                max_profit = prices[i] - buy;
            }
        }
        return max_profit;
    }
};