class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        for(int i = 0 ; i < heights.size(); i++){
            int largestIndex = i;
            for(int j = i+1 ; j < heights.size() ; j++){
                if(heights[j] > heights[largestIndex]){
                    largestIndex = j;
                }
            }
            if(i != largestIndex){
                int temp = heights[i];
                heights[i] = heights[largestIndex];
                heights[largestIndex] = temp;
                string tempString = names[i];
                names[i] = names[largestIndex];
                names[largestIndex] = tempString;
            }
        }
        return names;
    }
};