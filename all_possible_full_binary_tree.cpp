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
    vector<TreeNode*> allPossibleFBT(int n) {
        if(n%2 == 0) return {};
        if(n == 1) return {new TreeNode(0)};

        vector<TreeNode*> result;
        for(int leftNodes = 1 ; leftNodes < n ; leftNodes++){
            vector<TreeNode*> leftSubtrees = allPossibleFBT(leftNodes);
            vector<TreeNode*> rightSubtrees = allPossibleFBT(n - leftNodes - 1);
            for(auto leftTree : leftSubtrees){
                for(auto rightTree : rightSubtrees){
                    TreeNode* root = new TreeNode(0);
                    root->left = leftTree;
                    root->right = rightTree;
                    result.push_back(root);
                }
            }
        }
        return result;
    }
};