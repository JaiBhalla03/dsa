class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

//another easier way
class Solution {
    public int findDuplicate(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                ans.add(Math.abs(nums[i]));
            }
            else{
                nums[index] = -nums[index];
            }
        }
        return ans.get(0);
    }
}