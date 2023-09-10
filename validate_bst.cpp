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
    void helper(TreeNode* root, vector<int> &ans, bool &check){
        if(root == nullptr){
            return;
        }
        helper(root->left, ans, check);
        if(ans.size() > 0){
            if(root->val <= ans[ans.size()-1]){
                check = false;
            }
        }
        ans.push_back(root->val);
        helper(root->right, ans, check);
    }
    bool isValidBST(TreeNode* root) {
        vector<int> ans;
        bool check = true;
        helper(root, ans, check);
        return check;
    }
};