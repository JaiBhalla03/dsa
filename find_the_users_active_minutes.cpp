//brute force
class Solution {
public:
    bool notIn(int n , vector<int> a){
        for(int i  =0 ; i < a.size() ; i++){
            if(a[i] == n){
                return false;
            }
        }
        return true;
    }
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        vector<int> result(k, 0);
        vector<pair<int, int>> co;
        vector<bool> flag(logs.size(), false);
        vector<int> mins;
        pair<int, int> p;
        for(int i = 0 ; i < logs.size() ; i++){
            if(!flag[i]){
                int count = 0;
                for(int j = i ; j < logs.size() ; j++){
                    if(logs[i][0] == logs[j][0]){
                        flag[j] = true;
                        if(notIn(logs[j][1], mins)){
                            count++;
                        }
                        mins.push_back(logs[j][1]);
                    }
                }
                mins.clear();
                p = make_pair(logs[i][0], count);
                co.push_back(p);
            }
        }

        for(int i  = 0 ; i<co.size() ; i++){
            cout<<co[i].first<<" "<<co[i].second<<endl;
            result[co[i].second-1]++;
        }
        return result;
    }
};

//efficient approach
class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        unordered_map<int, unordered_set<int>> userActivity;
        vector<int> result(k, 0);
        for(int i = 0 ; i<logs.size() ; i++){
            userActivity[logs[i][0]].insert(logs[i][1]);
        }
        for(auto entry : userActivity){
            int activeMinutes = entry.second.size();
            if(activeMinutes <= k)
                result[activeMinutes-1]++;
        }
        return result;
    }
};