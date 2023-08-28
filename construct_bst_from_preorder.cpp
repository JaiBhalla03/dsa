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
    void insert(TreeNode*& root, int val){
        if(root->left == nullptr && root->val > val){
            TreeNode* temp = new TreeNode(val);
            root->left = temp;
            return;
        }
        if(root->right == nullptr && root->val < val){
            TreeNode* temp = new TreeNode(val);
            root->right = temp;
            return;
        }
        if(root->val > val){
            insert(root->left, val);
        }
        else if(root->val < val){
            insert(root->right, val);
        }
    }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode* root = new TreeNode(preorder[0]);
        for(int i= 1 ; i<preorder.size() ;i++){
            insert(root, preorder[i]);
        }
        return root;
    }
};