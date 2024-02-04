class Solution {
public:
    int maxStairHeight(int N) {
        int X = (1 + sqrt(1 + 8*N))/2;
        return X - 1;
    }
};