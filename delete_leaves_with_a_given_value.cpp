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
    bool isLeaf(TreeNode* node){
        return node->left == nullptr && node->right == nullptr;
    }
    void containsLeafTarget(TreeNode* root, int target, bool& flag){
        if(root == nullptr){
            return;
        }
        if(isLeaf(root) && root->val == target) flag = true;
        containsLeafTarget(root->left, target, flag);
        containsLeafTarget(root->right, target, flag);
    }
    void removeLeafTarget(TreeNode*& root, int target){
        if(root == nullptr){
            return;
        }
        if(isLeaf(root) && root->val == target) {
            root = nullptr;
            return;
        }
        removeLeafTarget(root->left, target);
        removeLeafTarget(root->right, target);
    }
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        bool flag = false;
        containsLeafTarget(root, target, flag);
        if(flag == true){
            removeLeafTarget(root, target);
            return removeLeafNodes(root, target);
        }
        else{
            return root;
        }
    }
};