class Solution {
    public int largestRectangleArea(int[] heights) {
        //the following solution will be require to find the left smaller and right small
        int n = heights.length;
        Stack<Integer> st = new Stack<Integer>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        //creating the left small array 
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftSmall[i] = 0;
            }
            else{
                leftSmall[i] = st.peek() + 1;
            }
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        //creating the right small array 
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightSmall[i] = n-1;
            }
            else{
                rightSmall[i] = st.peek() - 1;
            }
            st.push(i);
        }

        int maxA = 0;
        for(int i = 0 ; i < n ; i++){
            maxA = Math.max(maxA , (Math.abs(rightSmall[i] - leftSmall[i] + 1))*heights[i]);
        }
        return maxA;
    }
}