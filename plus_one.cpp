//brute force approach that does not work for the larger values
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        long long num = 0;
        for (int i = 0; i < digits.size(); i++) {
            num = num * 10 + digits[i];
        }
        num += 1;

        vector<int> result;
        while (num != 0) {
            int d = num % 10;
            num /= 10;
            result.push_back(d);
        }

        int k = result.size() - 1;
        for (int i = 0; i < result.size() / 2; i++) {
            int temp = result[i];
            result[i] = result[k];
            result[k] = temp;
            k--;
        }

        return result;
    }
};


//efficient approach using the carry variable
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry = 1;
        int n = digits.size();
        int i;
        for(i = n-1 ; i>=0 ; i--){
            int sum = carry + digits[i];
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0) break;
        }
        if(carry > 0){
            digits.insert(digits.begin(), carry);
        }
        return digits;
    }
};
