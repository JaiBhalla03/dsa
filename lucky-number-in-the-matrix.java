class Solution {
    public boolean check(int[][] matrix, int i, int j, int m, int n){
        for(int k = 0 ; k < m; k++){
            if(matrix[i][j] < matrix[k][j]) return false;
        }
        for(int k = 0 ; k < n ; k++){
            if(matrix[i][j] > matrix[i][k]) return false;
        }
        return true;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j ++){
                if(check(matrix, i, j, m, n)){
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}