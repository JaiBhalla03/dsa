class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        std::vector<int> result(m+n);
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j >=0){
            if(nums1[i] >= nums2[j]){
                result[k] = nums1[i];
                i--;
            }
            else{
                result[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            result[k] = nums2[j];
            j--;
            k--;
        }
        while(i >= 0){
            result[k] = nums1[i];
            i--;
            k--;
        }
        nums1 = result;
    }
};