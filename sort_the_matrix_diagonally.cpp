#include <vector>
#include <algorithm>

class Solution {
public:
    std::vector<std::vector<int>> diagonalSort(std::vector<std::vector<int>>& mat) {
        int rows = mat.size();
        int cols = mat[0].size();

        // Sort diagonals starting from the top row.
        for (int i = 0; i < rows; ++i) {
            sortDiagonal(mat, i, 0);
        }

        // Sort diagonals starting from the left column.
        for (int j = 1; j < cols; ++j) {
            sortDiagonal(mat, 0, j);
        }

        return mat;
    }

private:
    void sortDiagonal(std::vector<std::vector<int>>& mat, int row, int col) {
        int rows = mat.size();
        int cols = mat[0].size();
        std::vector<int> diagonal;

        // Extract the diagonal elements.
        while (row < rows && col < cols) {
            diagonal.push_back(mat[row][col]);
            ++row;
            ++col;
        }

        // Sort the diagonal elements.
        std::sort(diagonal.begin(), diagonal.end());

        // Update the matrix with sorted diagonal elements.
        while (row > 0 && col > 0) {
            --row;
            --col;
            mat[row][col] = diagonal.back();
            diagonal.pop_back();
        }
    }
};
