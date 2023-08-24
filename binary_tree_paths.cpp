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
    void helper(TreeNode* root, vector<string>& paths, string s){
        if(root == nullptr){
            return;
        }
        if(!s.empty()){
            s = s + "->";
        }
        s = s + to_string(root->val);
        if(root->left == nullptr && root->right == nullptr){
            paths.push_back(s);
        }
        helper(root->left, paths, s);
        helper(root->right, paths, s);
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        string s;
        helper(root, paths, s);

        return paths;
    }
};