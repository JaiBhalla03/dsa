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
    string solve(TreeNode* root, map<string,int> &m , vector<TreeNode*> &ans){
        if(root == nullptr) return "";
        string s =to_string(root->val) + ",";
        s+=solve(root->left, m, ans) + ",";
        s+=solve(root->right, m, ans);
        if(m[s] == 1){
            ans.push_back(root);
        }
        m[s]++;
        return s;
    }
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        map<string, int> m;
        vector<TreeNode*> ans;
        solve(root, m, ans);
        return ans;
    }
};
