class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        int sum = 0;
        sort(boxTypes.begin(), boxTypes.end(), [](auto& a, auto& b) {
            return a[1] > b[1];
        });
        for(auto x : boxTypes){
            if(x[0] <= truckSize){
                truckSize-=x[0];
                sum += x[0]*x[1];
            }
            else{
                sum += truckSize*x[1];
                break;
            }
        }
        return sum;
    }
};