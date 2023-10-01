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
    int depth(TreeNode* root){
        if(root == nullptr) return 0;
        return 1 + max(depth(root->left), depth(root->right));
    }
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        if(root == nullptr){
            return root;
        }
        int ld = depth(root->left);
        int rd = depth(root->right);
        if(ld == rd){
            return root;
        }
        else{
            if(ld > rd){
                return lcaDeepestLeaves(root->left);
            }
            else{
                return lcaDeepestLeaves(root->right);
            }
        }
    }
};