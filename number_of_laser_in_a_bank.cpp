class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int count = 0;
        int previous_security_device = 0;
        for(string s : bank){
            int next_security_device = 0;
            for(char c : s){
                if(c == '1'){
                    next_security_device++;
                }
            }
            if(next_security_device > 0){
                count += previous_security_device * next_security_device;
                previous_security_device = next_security_device;
            }
        }
        return count;
    }
};
