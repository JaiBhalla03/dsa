class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int sum = 0;
        int i = 1;
        bool flag = false;
        while(true){
            sum = i;
            for(int j = 0 ; j < nums.size() ; j ++){
                sum += nums[j];
                if(sum < 1){
                    flag = true;
                }
            }
            if(flag == false){
                return i;
            }
            else{
                flag = false;
                i++;
            }
        }
    }
};