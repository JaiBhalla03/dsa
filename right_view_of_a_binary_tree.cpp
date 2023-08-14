/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> finalAns;
        vector<vector<int>> ans;
        if(root == nullptr){
            return finalAns;
        }
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int levelSize = q.size();
            vector<int> temp;
            for(int i = 0 ; i<levelSize; i++){
                TreeNode* node = q.front();
                q.pop();
                temp.push_back(node->val);
                if(node->left != nullptr) q.push(node->left);
                if(node->right != nullptr) q.push(node->right);
            }
            ans.push_back(temp);
        }

        for(int i = 0 ;i <ans.size(); i++){
            for(int j = 0 ; j < ans[i].size() ;j++){
                if(j == ans[i].size()-1) finalAns.push_back(ans[i][j]);
            }
        }
        return finalAns;
    }
};