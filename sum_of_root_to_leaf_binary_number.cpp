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
    int helper(TreeNode* root, int path){
        if(root == nullptr){
            return 0;
        }

        path = path*2 + root->val;

        if(root->left == nullptr && root->right == nullptr){
            return path;
        }

        int leftSum = helper(root->left, path);
        int rightSum = helper(root->right, path);
        return leftSum + rightSum;
    }
    int sumRootToLeaf(TreeNode* root) {
        return helper(root, 0);
    }
};