class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        vector<int> kthScore;
        for(int i = 0 ; i < score.size() ; i ++){
            for(int j = 0 ; j < score[i].size() ; j++){
                if(j == k){
                    kthScore.push_back(score[i][j]);
                }
            }
        }
        for(int i = 0  ; i<kthScore.size() ; i++){
            int largest = i;
            for(int j = i+1 ; j < kthScore.size() ; j++){
                if(kthScore[j] > kthScore[largest]){
                    largest=j;
                }
            }
            int t = kthScore[i];
            kthScore[i] = kthScore[largest];
            kthScore[largest] = t;
            std:swap(score[largest], score[i]);
        }

        for(auto x : kthScore){cout<<x<<" ";}
        return score;
    }
};