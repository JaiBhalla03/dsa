
class Solution
{

    bool isSafe(int grid[N][N], int row, int col, int num){
        for(int i = 0  ; i < N ; i++){
            if(grid[row][i] == num || grid[i][col] == num){
                return false;
            }
        }
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(grid[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }
    bool solveSodukoUtil(int grid[N][N]){
        for(int row = 0 ; row < N ; row++){
            for(int col = 0 ; col < N ; col++){
                if(grid[row][col] == 0){
                    for(int num = 1 ; num <= 9 ; num++){
                        if(isSafe(grid, row, col, num)){
                            grid[row][col] = num;
                            if(solveSodukoUtil(grid)) return true;
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
public:
    bool SolveSudoku(int grid[N][N])
    {
        if(solveSodukoUtil(grid)){
            return true;
        }
        return false;
    }

    //Function to print grids of the Sudoku.
    void printGrid (int grid[N][N])
    {
        for(int row = 0 ; row < N ; row ++){
            for(int col = 0 ; col < N ; col++){
                cout<<grid[row][col]<<" ";
            }
        }
    }
};