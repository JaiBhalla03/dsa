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
    int height(TreeNode* root){
        if(root == nullptr) return 0;
        return max(height(root->left), height(root->right)) + 1;
    }
    int diameter(TreeNode* root){
        if(root == nullptr) return 0;
        int lefth = height(root->left);
        int righth = height(root->right);
        int diameterl = diameter(root->left);
        int diameterr = diameter(root->right);
        int currDiameter = lefth + righth;
        return max(currDiameter,max( diameterl, diameterr));
    }
    int diameterOfBinaryTree(TreeNode* root) {
        return diameter(root);
    }
};