class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, pair<int, int>> freq;
        vector<int> result;
        for(int i = 0  ; i < nums1.size() ; i++){
            freq[nums1[i]].first++;
        }
        for(int i = 0 ; i< nums2.size() ; i++){
            freq[nums2[i]].second++;
        }
        for(auto i : freq){
            if(i.second.first > 0 && i.second.second){
                result.push_back(i.first);
            }
        }
        return result;
    }
};