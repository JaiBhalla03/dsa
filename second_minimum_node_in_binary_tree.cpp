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
    void helper1(TreeNode* root, int &first){
        if(root == nullptr){
            return;
        }
        helper1(root->left, first);
        first = min(first, root->val);
        helper1(root->right, first);
    }
    void helper2(TreeNode* root, int first, int &second, bool &flag){
        if(root == nullptr){
            return;
        }
        helper2(root->left, first, second, flag);
        if(root->val != first){
            second = min(second, root->val);
            flag = true;
        }
        helper2(root->right, first, second, flag);
    }
    int findSecondMinimumValue(TreeNode* root) {

        int first = INT_MAX;
        int second = INT_MAX;
        bool flag = false;
        helper1(root, first);
        helper2(root, first, second, flag);
        return flag ? second : -1;
    }
};