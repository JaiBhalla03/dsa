//recursive approach
class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        if(n %4 ==1 || n%4 == 2 || n%4 == 3 )return false;
        return isPowerOfFour(n/4);
    }
};

//iterative approach
class Solution {
public:
    int fib(int n) {
        int a = 0;
        int b = 1;
        int c;
        if(n == 0) return a;
        if(n == 1) return b;
        while(n-2 >=0){
            c = a+b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }
};

//this has better time complexity