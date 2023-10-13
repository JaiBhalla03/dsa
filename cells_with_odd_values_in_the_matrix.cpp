class Solution {
public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        vector<vector<int>> mat(m,vector<int>(n,0));
        for(auto i:indices)
        {
            for(int j=0;j<n;j++)
                mat[i[0]][j]++;
            for(int j=0;j<m;j++)
                mat[j][i[1]]++;
        }
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                if(mat[i][j] & 1)
                    cnt++;
        }
        return cnt;
    }
};