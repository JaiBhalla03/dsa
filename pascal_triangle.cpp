class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        if(numRows == 1){
            return {{1}};
        }
        else if(numRows == 2){
            return {{1}, {1,1}};
        }
        else{
            vector<vector<int>> result = {{1},{1,1}};
            int k = 3;
            for(int i = 0 ; i < numRows - 2 ; i++){
                vector<int> current;
                for(int j = 0 ; j < k ; j++){
                    if(j == 0 || j == k - 1){
                        current.push_back(1);
                    }
                    else{
                        current.push_back(result[k-2][j-1] + result[k-2][j]);
                    }
                }
                k++;
                result.push_back(current);
                current.clear();
            }
            return result;
        }
    }
};