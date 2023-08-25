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
    bool isMirror(TreeNode* root1, TreeNode* root2){
        if(root1 == nullptr && root2 == nullptr) return true;
        else if(root1 && root2 && root1->val == root2->val) return isMirror(root1->left , root2->right) && isMirror(root1->right, root2->left);
        else return false;
    }
    bool isSymmetric(TreeNode* root) {
        bool flag = isMirror(root->left, root->right);
        return flag;
    }
};

//this is the recursive method

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

    bool isSymmetric(TreeNode* root) {
        if(root == nullptr) return true;
        stack<TreeNode*> s;
        s.push(root->left);
        s.push(root->right);
        while(!s.empty()){
            TreeNode* node1 = s.top();
            s.pop();
            TreeNode* node2 = s.top();
            s.pop();
            if(node1 == nullptr && node2 == nullptr) continue;
            if(node1 == nullptr || node2 == nullptr) return false;
            if(node1->val != node2->val) return false;
            s.push(node1->left);
            s.push(node2->right);
            s.push(node1->right);
            s.push(node2->left);
        }
        return true;
    }
};

//this is the iterative approach
