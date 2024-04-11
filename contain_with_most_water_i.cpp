class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxArea = INT_MIN;
        int left = 0;
        int right = height.size()-1;
        while(left < right){
            int currentHeight = min(height[left], height[right]);
            int currentWidth = right - left;
            int area = currentHeight*currentWidth;
            maxArea = max(area, maxArea);
            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
};