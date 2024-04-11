//brute force
class Solution {
public:
    bool present(vector<int> nums, int num){
        int i;
        for(i = 0 ; i<nums.size() ; i++){
            if(nums[i] == num){
                return true;
            }
        }
        return false;
    }
    vector<int> removeDuplicate(vector<int> nums){
        std::set<int> myset(nums.begin(), nums.end());
        std::vector<int> result(myset.begin(), myset.end());
        return result;
    }
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        vector<int> copy1 = nums1;
        vector<int> copy2 = nums2;
        vector<vector<int>> result;
        copy1 = removeDuplicate(copy1);
        copy2 = removeDuplicate(copy2);
        for(int i = 0 ; i< copy1.size(); i++){
            cout<<copy1[i]<<" ";
        }
        for(int i = 0 ; i< copy2.size(); i++){
            cout<<copy2[i]<<" ";
        }
        int i = 0;
        while(i <copy1.size()){
            if(present(nums2, copy1[i])){
                copy1.erase(copy1.begin() + i);
                i=  0;
            }
            else{
                i++;
            }
        }
        i = 0;
        while(i <copy2.size()){
            if(present(nums1, copy2[i])){
                copy2.erase(copy2.begin() + i);
                i=  0;
            }
            else{
                i++;
            }
        }
        result.push_back(copy1);
        result.push_back(copy2);
        return result;
    }
};

//efficient way
class Solution {
public:
    bool present(vector<int> nums, int num){
        int i;
        for(i = 0 ; i<nums.size() ; i++){
            if(nums[i] == num){
                return true;
            }
        }
        return false;
    }
    vector<int> removeDuplicate(vector<int> nums){
        std::set<int> myset(nums.begin(), nums.end());
        std::vector<int> result(myset.begin(), myset.end());
        return result;
    }
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        vector<int> copy1 = nums1;
        vector<int> copy2 = nums2;
        vector<vector<int>> result;
        copy1 = removeDuplicate(copy1);
        copy2 = removeDuplicate(copy2);
        vector<int> diff1;
        vector<int> diff2;
        for(int num : copy1){
            if(find(copy2.begin() , copy2.end() , num) == copy2.end()){
                diff1.push_back(num);
            }
        }
        for(int num : copy2){
            if(find(copy1.begin() , copy1.end() , num) == copy1.end()){
                diff2.push_back(num);
            }
        }
        result.push_back(diff1);
        result.push_back(diff2);
        return result;
    }
};