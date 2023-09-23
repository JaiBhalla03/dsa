class Solution {
public:
    int divisorSubstrings(int num, int k) {
        string str = to_string(num);
        int count = 0;
        for(int i = 0 ; i <= str.size()-k ; i++){
            string s = "";
            for(int j = i ; j < i+k ; j++){
                s += str[j];
            }
            int x = stoi(s);
            if(x != 0){
                if(num%x == 0) count++;
            }
        }
        return count;
    }
};


//effiecient method
