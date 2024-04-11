/*
 * case 1: the node is leaf node
 * case 2: the node has one children
 * case 3: the node has two children
 *
 * step 1: find the inorder successor
 * step 2: replace with the inorder successor
 * step 3: delete the node
 *
 * check where the key lie  if the in the left then call for the left
 * if right then call
 * */

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
    TreeNode* inorderSuccessor(TreeNode* root){
        TreeNode* curr = root;
        while(curr && curr->left){
            curr = curr->left;
        }
        return curr;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == nullptr) return nullptr;
        if(key < root->val){
            root->left = deleteNode(root->left , key);
        }
        else if(key > root->val){
            root->right = deleteNode(root->right, key);
        }
        else{
            if(root->left == nullptr){
                TreeNode* temp = root->right;
                delete root;
                return temp;
            }
            else if(root->right == nullptr){
                TreeNode* temp = root->left;
                delete root;
                return temp;
            }
            TreeNode* temp = inorderSuccessor(root->right);
            root->val = temp->val;
            root->right = deleteNode(root->right, temp->val);
        }
        return root;
    }
};

