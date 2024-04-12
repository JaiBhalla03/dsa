class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(height[left], leftMax);
                ans += Math.abs(leftMax - height[left]);
            }
            else{
                right--;
                rightMax = Math.max(height[right], rightMax);
                ans += Math.abs(rightMax - height[right]);
            }
        }
        return ans;
    }
}