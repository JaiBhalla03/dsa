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
    void helper(bool& check, TreeNode* p, TreeNode* q, int& flag){
        if(p == nullptr && q != nullptr){
            check = false;
            flag = 1;
            return;
        }
        if(p != nullptr && q == nullptr){
            check = false;
            flag = 1;
            return;
        }
        if(p == nullptr && q == nullptr) return;

        if(p && q){
            check = p->val == q->val;
            if(!check) flag = 1;
        }
        helper(check, p ? p->left : nullptr,q ? q->left : nullptr, flag);
        helper(check,p? p->right : nullptr,q ? q->right : nullptr, flag);
    }
    bool isSameTree(TreeNode* p, TreeNode* q) {
        bool check = true;
        int flag = 0;
        helper(check, p , q, flag);
        return flag ? false : true;
    }
};