class Solution {
    /**
     -> traverse the string from left to right
     -> for each character do the following
     if it is ( increase the low and high by 1
     if it is ) decreaes low by 1 and high decrease by 1 unless low is already zero
     if it is * low decreases by 1 and high increases by 1
     if high becomes negative just return false because it means that the ( is not equal to )
     -> outside the loop check if low is 0 or not
     if low is 0 return true
     else return false
     */
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            low += (c == '(') ? 1 : -1;
            high += (c != ')') ? 1 : -1;
            if(high < 0) return false;
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}