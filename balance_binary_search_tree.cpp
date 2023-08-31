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
    TreeNode* helper2(vector<int> inorder, int start, int end){
        if(start > end) return nullptr;
        int mid = start + (end-start)/2;
        TreeNode* root = new TreeNode(inorder[mid]);
        root->left = helper2(inorder, start, mid-1);
        root->right = helper2(inorder, mid+1, end);
        return root;
    }
    void helper1(TreeNode* root, vector<int>& inorder){
        if(root == nullptr) return;
        helper1(root->left, inorder);
        inorder.push_back(root->val);
        helper1(root->right, inorder);
    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> inorder;
        helper1(root, inorder);
        return helper2(inorder, 0, inorder.size()-1);
    }
};

/*
 * this is brute force approach where we just find do the inorder traversal and then recursively generate the tree with the helper funciton
 * */

//better approach is morris traversal
