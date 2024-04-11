class Solution {
public:
    int reverse(int num){
        int r = 0;
        while(num != 0){
            int d = num%10;
            num/=10;
            r = r*10 + d;
        }
        return r;
    }
    bool isSameAfterReversals(int num) {
        return num == reverse(reverse(num));
    }
};