class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int max = 0;
        for(auto x : candies){
            if(x > max){
                max = x;
            }
        }
        vector<bool> arr;
        for(int i = 0  ; i < candies.size() ; i++){
            if(candies[i] + extraCandies >= max){
                arr.push_back(true);
            }
            else{
                arr.push_back(false);
            }
        }
        return arr;
    }
};