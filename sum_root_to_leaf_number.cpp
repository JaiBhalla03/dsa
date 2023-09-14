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
    void helper(TreeNode* root, int temp, int &sum){
        if(root == nullptr){
            return;
        }
        if(root->left == nullptr && root->right == nullptr){
            temp = temp*10 + root->val;
            sum += temp;
            return;
        }
        temp = temp*10 + root->val;
        helper(root->left, temp, sum);
        helper(root->right, temp, sum);
        temp = temp/10;
    }
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        int temp = 0;
        helper(root, temp, sum);
        return sum;
    }
};