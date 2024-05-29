//brute force

class Solution {
    public int helper(int[] nums, int l, int r, int x){
        List<Integer> arr = new ArrayList<>();
        int count = 0;
        for(int i = l ; i <= r ; i++){
            arr.add(nums[i]);
            if(nums[i] < 0) count++;
        }
        Collections.sort(arr);
        return count < x ? 0 : arr.get(x-1);
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int size = n - k + 1;
        int[] result = new int[size];
        int l = 0;
        int r = k-1;
        int i = 0;
        while(r < n){
            result[i] = helper(nums, l , r, x);
            l++;
            r++;
            i++;
        }
        return result;
    }
}

//optimised
