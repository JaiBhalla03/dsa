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
    void isEqual(bool& flag, TreeNode* root1, TreeNode* root2){
        if(root1 == nullptr && root2 != nullptr) flag = false;
        if(root1 != nullptr && root2 == nullptr) flag = false;
        if(root1 == nullptr && root2 == nullptr){return;}
        if(root1 && root2){
            if(root1->val != root2->val) {
                flag = false;
            }
        }
        isEqual(flag, root1 ? root1->left : nullptr, root2 ? root2->left : nullptr);
        isEqual(flag, root1 ? root1->right : nullptr, root2 ? root2->right : nullptr);
    }
    void helper(TreeNode* root,TreeNode* subRoot,bool& check){
        if(root == nullptr){
            return;
        }
        bool flag = true;
        isEqual(flag, root, subRoot);
        if(flag) check = true;
        helper(root->left, subRoot, check);
        helper(root->right, subRoot, check);
    }
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        bool check = false;
        helper(root, subRoot, check);
        return check;
    }
};