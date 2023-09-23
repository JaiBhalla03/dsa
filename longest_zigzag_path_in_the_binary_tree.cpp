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
    int rightLeft(TreeNode* root, bool flag){
        if(root == nullptr) return 0;
        return flag ? 1 + rightLeft(root->right, !flag) : 1 + rightLeft(root->left, !flag);
    }
    void helper(TreeNode* root, int &ans){
        if(root == nullptr) return;
        ans = max(ans, max(rightLeft(root, true), rightLeft(root, false)));
        helper(root->left, ans);
        helper(root->right, ans);
    }
    int longestZigZag(TreeNode* root) {
        int ans = 0;
        helper(root, ans);
        return ans-1;
    }
};


//efficient approach
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
    void helper(TreeNode* root, bool is_right, int length, int &max_length){
        if(root == nullptr) return;
        max_length = max(max_length, length);
        if(is_right){
            helper(root->right, false, length + 1, max_length);
            helper(root->left, true, 1, max_length);
        }
        else{
            helper(root->left, true, length + 1, max_length);
            helper(root->right, false, 1, max_length);
        }
    }
    int longestZigZag(TreeNode* root) {
        int max_length = 0;
        helper(root, false, 0, max_length);
        helper(root, true, 0, max_length);
        return max_length;
    }
};