class Solution{
public:
    vector<int> minPartition(int N)
    {
        vector<int> denomination = {1,2,5,10,20,50,100,200,500,2000};
        vector<int> ans;
        int n = denomination.size()-1;
        for(int i = n ; i >= 0 ; i--){
            if(denomination[i] > N){
                continue;
            }
            else{
                ans.push_back(denomination[i]);
                N -= denomination[i];
                while(N >= denomination[i]){
                    ans.push_back(denomination[i]);
                    N -= denomination[i];
                }
            }
        }
        return ans;
    }
};