class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        int count = 0;
        int maxCount = 0;
        int i, j;
        string w = "";
        for(i = 0 ; i < sentences.size() ; i++){
            count = 0;
            sentences[i] += " ";
            for(j = 0 ; j < sentences[i].size() ; j++){
                char ch = sentences[i][j];
                if(ch != ' '){
                    w = w+ch;
                }
                else{
                    count++;
                    w = "";
                }
            }
            maxCount = max(count, maxCount);
        }
        return maxCount;
    }
};