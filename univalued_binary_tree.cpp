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
        helper(root->left, inorder);
        inorder.push_back(root->val);
        helper(root->right, inorder);
    }
    bool isUnivalTree(TreeNode* root) {
        vector<int> inorder;
        helper(root, inorder);
        if(inorder.size() == 1) return true;
        for(int i = 0 ; i < inorder.size()-1;i++){
            if(inorder[i+1] != inorder[i]) return false;
        }
        return true;
    }
};


//method that take little space
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
    void helper(TreeNode* root, bool &flag, int &check){
        if(root == nullptr){
            return;
        }
        if(root->left && root->right)
            flag = root->val == root->left->val && root->val == root->right->val;
        else if(root->left && !root->right) flag = root->val == root->left->val;
        else if(!root->left && root->right) flag = root->val == root->right->val;
        if(flag == false) check = 1;
        helper(root->left, flag, check);
        helper(root->right, flag, check);
    }
    bool isUnivalTree(TreeNode* root) {
        if(root != nullptr && root->left == nullptr && root->right == nullptr){
            return true;
        }
        bool flag = true;
        int check = 0;
        helper(root, flag, check);
        return (check == 1) ? false : true;
    }
};