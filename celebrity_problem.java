class Solution
{
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            st.push(i);
        }
        while(st.size() > 1){
            int row = st.pop();
            int col = st.pop();
            if(M[row][col] == 1){
                st.push(col);
            }
            else{
                st.push(row);
            }
        }
        int x = st.pop();
        //condition when there are no celebrities
        //if celebrity knows someone
        for(int i = 0 ; i < n ; i ++){
            if(M[x][i] == 1) return -1;
        }
        //if there is someone that do not know celebrity
        for(int i = 0 ; i < n ; i++){
            if(i != x && M[i][x] == 0) return -1;
        }
        return x;
    }
}