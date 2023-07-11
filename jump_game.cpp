class solution{
    bool jumpGame(vector<int>& num){
        int reachable = 0;
        int i;
        int n = num.size();
        for(i = 0;i<n;i++){
            if(i > reachable){
                return false;
            }
            reachable = max(reachable, i + num[i]);
        }
        return true;
    }
};