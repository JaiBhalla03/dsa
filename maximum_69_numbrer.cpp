class Solution {
public:
    int maximum69Number (int num) {
        int cover = 1;
        while(cover < num){
            cover *= 10;
        }
        //cover = 10000;
        cover/=10;
        //cover = 1000;
        int newNumber = 0;
        bool flag = true;
        while(cover >= 1){
            int x = num/cover;
            x = x%10;
            if(x == 6 && flag){
                x = 9;
                flag = false;
            }
            newNumber = newNumber*10 + x;
            cover/=10;
        }
        return newNumber;
    }
};