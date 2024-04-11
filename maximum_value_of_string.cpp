class Solution {
public:
    bool completeDigit(string el){
        for(int i = 0 ; i<el.size() ; i++){
            if(!isdigit(el[i])){
                return false;
            }
        }
        return true;
    }
    int maximumValue(vector<string>& strs) {
        int maxi = 0;
        int current;
        for(int i = 0 ; i<strs.size() ; i++){
            if(completeDigit(strs[i])){
                current = std::stoi(strs[i]);
            }
            else{
                current = strs[i].size();
            }
            maxi = max(maxi, current);
        }
        return maxi;
    }
};