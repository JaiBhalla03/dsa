class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        int n = arr.size();
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                arr.insert(arr.begin() + i, 0);
                i++;
            }
        }
        vector<int> result;
        for(int i = 0 ; i < n ; i++){
            result.push_back(arr[i]);
        }
        arr = result;
    }
};