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
    void helper(TreeNode* root, int k, int &count, int &ans){
        if(root == nullptr) return;
        helper(root->left, k, count, ans);
        count++;
        if(k == count){
            ans = root->val;
            return;
        }
        helper(root->right, k, count, ans);
    }
    int kthSmallest(TreeNode* root, int k) {
        int ans;
        int count = 0;
        helper(root, k, count, ans);
        return ans;
    }
};