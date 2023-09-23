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
    void helper(TreeNode* root, vector<vector<int>> &paths, vector<int> temp){
        if(root == nullptr){
            temp.pop_back();
            return;
        }
        temp.push_back(root->val);
        paths.push_back(temp);
        helper(root->left, paths, temp);
        helper(root->right, paths, temp);
    }
    bool isGood(vector<int> arr){
        if(arr.size() == 1) return true;
        for(int i = arr.size()-1 ; i >= 0 ; i--){
            if(arr[i] > arr[arr.size()-1]) return false;
        }
        return true;
    }
    int goodNodes(TreeNode* root) {
        vector<vector<int>> paths;
        vector<int> temp;
        helper(root, paths, temp);
        int count = 0;
        for(auto x : paths){
            if(isGood(x)){
                count ++;
            }
        }
        return count;
    }
};