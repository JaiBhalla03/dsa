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
    void helper(TreeNode* root, unordered_map<int, int> &freq){
        if(root == nullptr) return;
        freq[root->val]++;
        helper(root->left, freq);
        helper(root->right, freq);
    }
    vector<int> findMode(TreeNode* root) {
        int m = 0;
        int l = 0;
        TreeNode* temp = root;
        while(temp){
            m = temp->val;
            temp = temp->right;
        }
        temp = root;
        while(temp){
            l = temp->val;
            temp = temp->left;
        }
        unordered_map<int, int> freq;
        helper(root, freq);
        vector<int> ans;
        int maxFreq = 0;
        for(int i = l ; i <= m ; i++){
            maxFreq = max(maxFreq, freq[i]);
        }
        for(int i = l ; i<= m ; i++){
            if(freq[i] == maxFreq){
                ans.push_back(i);
            }
        }
        return ans;
    }
};