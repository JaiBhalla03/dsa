class Solution {
public:
    int xorOperation(int n, int start) {
        vector<int> arr;
        for(int i = 0 ; i<n ; i++){
            arr.push_back(start + 2*i);
        }
        int ans = arr[0];
        if(arr.size() > 1){
            for(int i = 1 ; i < arr.size() ; i++){
                ans = ans^arr[i];
            }
        }
        return ans;
    }
};