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
    void sumOfNode(TreeNode* root, int& sum, int& count){
        if(root == nullptr) return;
        sumOfNode(root->left, sum, count);
        sum += root->val;
        count++;
        sumOfNode(root->right, sum, count);
    }
    bool isFunction(TreeNode* root, int num){
        int sum = 0;
        int count = 0;
        sumOfNode(root, sum, count);
        return num == sum/count;
    }
    void helper(TreeNode* root, int& count){
        if(root == nullptr){return;}
        if(isFunction(root, root->val)) count++;
        helper(root->left, count);
        helper(root->right, count);
    }
    int averageOfSubtree(TreeNode* root) {
        int count = 0;
        helper(root, count);
        return count;
    }
};
