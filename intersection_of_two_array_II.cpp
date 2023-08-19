//this is the brute force approach

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        vector<int> intersect;
        vector<bool> flag(n1>n2 ? n1 : n2, false);
        for(int i=0 ; i<nums1.size() ;i++){
            for(int j = 0 ; j<nums2.size() ;j++){
                if(!flag[j]){
                    if(nums1[i] == nums2[j]){
                        flag[j] = true;
                        intersect.push_back(nums1[i]);
                        break;
                    }
                }
            }
        }

        return intersect;
    }
};

//efficient approach
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> freqnum;
        vector<int> intersect;
        for(auto num : nums1){
            freqnum[num]++;
        }
        for(auto num : nums2){
            if(freqnum.find(num) != freqnum.end() && freqnum[num] > 0){
                freqnum[num]--;
                intersect.push_back(num);
            }
        }
        return intersect;
    }
};

//this approach has a lower time complexity but takes more space
