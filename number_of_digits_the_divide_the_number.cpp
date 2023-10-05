class Solution {
public:
    int countDigits(int num) {
        int copy = num;
        int count = 0;
        while(copy != 0){
            int d = copy%10;
            if(num%d == 0) count++;
            copy/=10;
        }
        return count;
    }
};