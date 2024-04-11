class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        //first make the -1 to 1e9
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)(1e9);
                }
            }
        }

        for(int via = 0 ; via < n ; via++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        //change the 1e9 back to -1
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}