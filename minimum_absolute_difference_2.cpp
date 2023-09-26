class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        std::sort(arr.begin(), arr.end());
        int minDiff = INT_MAX;
        vector<vector<int>> ans;
        vector<int> temp;
        for(int i = 0 ; i < arr.size()-1 ; i++){
            int a = arr[i];
            int b = arr[i+1];
            if(b - a < minDiff){
                minDiff = b-a;
            }
        }
        for(int i = 0 ; i < arr.size()-1 ; i++){
            int a = arr[i];
            int b = arr[i+1];
            if(b - a == minDiff){
                temp.push_back(a);
                temp.push_back(b);
                ans.push_back(temp);
            }
            temp.clear();
        }
        return ans;
    }
};