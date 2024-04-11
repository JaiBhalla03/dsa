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
    void helper(TreeNode* root, vector<int>& ans){
        if(root == nullptr){
            return;
        }
        helper(root->left, ans);
        ans.push_back(root->val);
        helper(root->right, ans);
    }
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> ans1;
        vector<int> ans2;
        vector<int> ans;
        helper(root1, ans1);
        helper(root2, ans2);
        int n1 = ans1.size();
        int n2 = ans2.size();
        int x = 0, y = 0;
        while(x < n1 && y < n2){
            if(ans1[x] < ans2[y]){
                ans.push_back(ans1[x]);
                x++;
            }
            else{
                ans.push_back(ans2[y]);
                y++;
            }
        }
        while(x != n1){
            ans.push_back(ans1[x]);
            x++;
        }
        while(y != n2){
            ans.push_back(ans2[y]);
            y++;
        }
        return ans;
    }
};