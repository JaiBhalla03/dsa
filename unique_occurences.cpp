class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> freq;
        for(auto x : arr){
            freq[x]++;
        }
        unordered_set<int> seen;
        for(auto x : freq){
            if(seen.find(x.second) != seen.end()){
                return false;
            }
            else seen.insert(x.second);
        }
        return true;
    }
};