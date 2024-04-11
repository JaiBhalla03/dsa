//brute force approach uses has time complexity of 2^n
class Solution {
public:
    int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 1 || n == 0) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
};

//what can be efficient approach ?
