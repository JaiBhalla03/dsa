class Solution {
    public int divide(int dividend, int divisor) {

        int s = 1;
        long q = 0;


        if((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)) {
            s = -1;
        }
        long d1=dividend, d2=divisor;
        d1 = Math.abs(d1);
        d2 =  Math.abs(d2);

        System.out.println(d1);
        System.out.println(d2);

        while(d1 >= d2){
            d1 -= d2;
            q++;
        }


        if(q >= Integer.MAX_VALUE && s == 1) return Integer.MAX_VALUE;
        if(q >= Integer.MAX_VALUE && s == -1) return Integer.MIN_VALUE;
        return (int)q*s;
    }

    public static void main(String[] args){
        System.out.println(divide(7,1));
    }
}