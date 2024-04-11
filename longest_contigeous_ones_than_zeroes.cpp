class Solution {
public:
    bool checkZeroOnes(string s) {
        int count0 = 0 , count1 = 0, max0 = 0, max1 = 0;
        int n = s.size();
        for(int i = 0 ; i < n ; i++){
            if(s[i] == '0'){
                count0++;
                if(count1){
                    max1 = max(max1, count1);
                    count1 = 0;
                }
            }
            else if(s[i] == '1'){
                count1++;
                if(count0){
                    max0 = max(max0, count0);
                    count0 = 0;
                }
            }
        }
        max0 = max(max0, count0);
        max1 = max(max1, count1);
        return max1 > max0;
    }
};