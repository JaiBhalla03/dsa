//this is the recursive solution however

class Solution {
public:

    double myPow(double x, int n) {
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n == 0) return 1;
        n = (n > 0) ? n-1 : n+1;
        return (n > 0) ? x*myPow(x, n) : (1/x)*myPow(x, n);
    }
};

//this will cause an overflow

class Solution {
public:

    double myPow(double x, int n) {

        double halfpower= pow(x, n/2);
        if(n%2 == 0) return halfpower* halfpower;
        else if(n>0) return x*halfpower*halfpower;
        else return (1/x)*halfpower*halfpower;
    }
};