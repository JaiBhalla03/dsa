class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        //first swap all the elements to the correct position in the array that is for num[i] == i+1
        for(int i = 0 ; i < nums.length ; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}