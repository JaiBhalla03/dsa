//brute force
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
    void helper(TreeNode* root, vector<int>& inorder){
        if(root == nullptr){
            return;
        }
        helper(root->left, inorder);
        inorder.push_back(root->val);
        helper(root->right, inorder);
    }
    TreeNode* increasingBST(TreeNode* root) {
        vector<int> inorder;
        helper(root, inorder);
        TreeNode* result = new TreeNode(0);
        TreeNode* newNode = new TreeNode(inorder[0]);
        result->right = newNode;
        for(int i=1 ; i<inorder.size(); i++){
            newNode->right = new TreeNode(inorder[i]);
            newNode = newNode->right;
        }
        return result->right;
    }
};

//but this method will have a lot of extra memory and time complexity

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
    void helper(TreeNode* root, TreeNode*& result){
        if(root == nullptr){
            return;
        }
        helper(root->left, result);
        result->right = new TreeNode(root->val);
        result =  result->right;
        helper(root->right, result);
    }
    TreeNode* increasingBST(TreeNode* root) {
        TreeNode* result = new TreeNode(0);
        TreeNode* curr = result;
        helper(root, curr);
        return result->right;
    }
};

//this is much better