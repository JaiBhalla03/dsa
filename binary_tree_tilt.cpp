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
    void sumOfNode(TreeNode* root, int& sum){
        if(root == nullptr){
            return;
        }
        sumOfNode(root->left, sum);
        sum += root->val;
        sumOfNode(root->right, sum);
    }
    void helper(TreeNode*& root){
        if(root == nullptr){
            return;
        }
        int sumL = 0, sumR = 0;
        sumOfNode(root->left, sumL);
        sumOfNode(root->right, sumR);
        root->val = abs(sumL - sumR);
        helper(root->left);
        helper(root->right);
    }
    int findTilt(TreeNode* root) {
        helper(root);
        int sum = 0;
        sumOfNode(root, sum);
        return sum;
    }
};