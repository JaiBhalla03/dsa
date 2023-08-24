//brute force which take more space
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
    int getMinimumDifference(TreeNode* root) {
        vector<int> inorder;
        helper(root, inorder);
        int minimum = INT_MAX;
        for(int i = 0 ; i < inorder.size()-1 ; i++){
            minimum = min(minimum, abs(inorder[i] - inorder[i+1]));
        }
        return minimum;
    }
};

//try to reduce the space complexity
