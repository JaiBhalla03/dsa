class Solution {
public:
    bool isHappy(int n) {
        int sum = 0;
        while(n != 0){
            int d = n%10;
            n = n/10;
            sum = sum + pow(d, 2);
        }
        if(sum == 1 || sum == 7) return true;
        if(sum >1 && sum <= 9){
            return false;
        }
        return isHappy(sum);
    }
};