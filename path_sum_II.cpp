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
    void helper(TreeNode* root, vector<vector<int>> &ans, vector<int> &temp, int &sum, int targetSum){
        if(root == nullptr){
            return;
        }
        sum+=root->val;
        temp.push_back(root->val);
        if(root->left == nullptr && root->right == nullptr){
            if(sum == targetSum){
                ans.push_back(temp);
            }
        }
        helper(root->left, ans, temp, sum, targetSum);
        helper(root->right, ans, temp, sum, targetSum);
        temp.pop_back();
        sum-=root->val;
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> temp;
        int sum = 0;
        helper(root, ans, temp, sum , targetSum);
        return ans;
    }
};