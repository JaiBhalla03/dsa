class Solution {
public:
    string defangIPaddr(string address) {
        string s = "";
        int i;
        for(i = 0 ; i<address.size() ; i++){
            if(address[i] == '.'){
                s+="[.]";
            }
            else{
                s+=address[i];
            }
        }
        return s;
    }
};