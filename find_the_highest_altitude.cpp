class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int altitude = 0;
        int maxA = 0;
        for(int i = 0 ; i < gain.size() ; i++){
            altitude += gain[i];
            maxA = max(maxA, altitude);
        }
        return maxA;
    }
};