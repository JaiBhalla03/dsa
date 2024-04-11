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
    int sumOfGrandChildren(TreeNode* root){
        if(root == nullptr) return 0;
        else if(root->left == nullptr && root->right == nullptr) return 0;
        int sum = 0;
        if(root->left){
            if(root->left->left) sum += root->left->left->val;
            if(root->left->right) sum += root->left->right->val;
        }
        if(root->right){
            if(root->right->left) sum += root->right->left->val;
            if(root->right->right) sum += root->right->right->val;
        }
        return sum;
    }
    void helper(TreeNode* root, int& totalSum){
        if(root == nullptr){
            return;
        }
        if(root->val % 2 == 0){
            totalSum = totalSum + sumOfGrandChildren(root);
        }
        helper(root->left, totalSum);
        helper(root->right, totalSum);
    }
    int sumEvenGrandparent(TreeNode* root) {
        int totalSum = 0;
        helper(root, totalSum);
        return totalSum;
    }
};
