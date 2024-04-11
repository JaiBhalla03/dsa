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
    void helper(TreeNode* root, vector<int>& inorder){
        if(root == nullptr){
            return;
        }
        helper(root->right, inorder);
        inorder.push_back(root->val);
        helper(root->left, inorder);
    }
    void helper2(TreeNode*& root, vector<int> inorder, int& index){
        if(root == nullptr){
            return;
        }
        helper2(root->right, inorder, index);
        root->val = inorder[index++];
        helper2(root->left, inorder, index);
    }
    TreeNode* bstToGst(TreeNode* root) {
        vector<int> inorder;
        helper(root, inorder);
        for(int i=1 ; i<inorder.size(); i++){
            inorder[i] = inorder[i] + inorder[i-1];
        }
        int index = 0;
        helper2(root, inorder, index);
        return root;
    }
};