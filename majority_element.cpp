/*
 * -> to find the majority element in an array the brute force approach gives a complexity of O(n^2)
 * CODE
 * class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int i, j, index;
        int max_count = 0;
        for(i = 0;i<n;i++){
            int count = 0;
            for(j = 0;j<n;j++){
                if(nums[j] == nums[i]){
                    count ++;
                }
            }
            if(max_count < count){
                max_count = count;
                index = i;
            }
        }
        if(max_count > n/2){
            return nums[index];
        }
        return -1;
    }
};
 * -> to get a complexity of O(n) use Boyer-Moore voting algorithms
 * ->  APPROACH
 *  variable will be candidate , count
 *  first the find the element repeated most time and then find it count
 *  simple logic of count += (num == candidate) ? 1: -1;
 * */

//correct approach
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        //using the boyer moore algorithm
        int candidate = 0, count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        count = 0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
        }
        return (count > nums.size()/2) ? candidate : -1;
    }
};