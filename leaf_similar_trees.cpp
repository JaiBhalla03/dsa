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
    void helper(TreeNode* root, vector<int>& arr){
        if(root == nullptr){
            return;
        }
        if(root->left == nullptr && root->right == nullptr){
            arr.push_back(root->val);
        }
        helper(root->left, arr);
        helper(root->right, arr);
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leaf1;
        vector<int> leaf2;
        helper(root1, leaf1);
        helper(root2, leaf2);
        int n1 = leaf1.size();
        int n2 = leaf2.size();
        if(n1 != n2) return false;
        for(int i = 0 ; i < n1 ;i++){
            if(leaf1[i] != leaf2[i]) return false;
        }
        return true;
    }
};