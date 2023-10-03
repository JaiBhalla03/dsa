class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.size()-1;
        int j = b.size()-1;
        int carry = 0;
        string ans = "";
        while(i >= 0 || j >=0 || carry >0){
            int digitA = (i >= 0) ? (a[i--] - '0') : 0;
            int digitB = (j >= 0) ? (b[j--] - '0') : 0;
            int sum = digitA + digitB + carry;
            carry = sum/2;
            sum = sum%2;
            ans = static_cast<char>(sum + '0') + ans;
        }
        return ans;
    }
};