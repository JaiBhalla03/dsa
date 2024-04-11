class Solution {
public:
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        ListNode* temp = head;
        vector<vector<int>> ans(m, vector<int>(n ,-1));
        int top = 0, bottom = m-1, left = 0 , right = n-1;
        while(top <= bottom && left <= right){
            for(int i = left ; i<=right ; i++){
                if(temp != NULL){
                    ans[top][i] = temp->val;
                    temp = temp->next;
                }
                else{
                    break;
                }
            }
            top++;
            for(int i = top ; i<=bottom ; i++){
                if(temp != NULL){
                    ans[i][right] = temp->val;
                    temp = temp->next;
                }
                else{
                    break;
                }
            }
            right--;

            for(int i = right ; i>=left ;i--){
                if(temp != NULL){
                    ans[bottom][i] = temp->val;
                    temp = temp->next;
                }
                else{
                    break;
                }
            }
            bottom--;
            for(int i = bottom ; i>=top; i--){
                if(temp != NULL){
                    ans[i][left] = temp->val;
                    temp = temp->next;
                }
                else{
                    break;
                }
            }
            left++;
        }
        return ans;
    }
};
