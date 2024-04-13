class Solution {
    public int helper(int[] height){
        int n = height.length;
        Stack<Integer> st = new Stack<Integer>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
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
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && height[st.peek()] >= height[i]){
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
            maxA = Math.max(maxA , (Math.abs(rightSmall[i] - leftSmall[i] + 1))*height[i]);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mat = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                mat[i][j] = (matrix[i][j] == '1')  ? 1 : 0;
            }
        }
        int[] height = new int[col];
        int maxA = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(mat[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            maxA = Math.max(maxA, helper(height));
        }
        return maxA;
    }
}