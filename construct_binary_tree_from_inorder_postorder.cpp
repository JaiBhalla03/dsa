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
    int search(vector<int> inorder, int start , int end, int x){
        for(int i = start ; i<=end;  i++){
            if(inorder[i] == x) return i;
        }
        return -1;
    }
    TreeNode* helper(vector<int> inorder, vector<int> postorder, int start , int end, int &index){
        if(start > end) return nullptr;
        int n = postorder[index];
        index--;
        TreeNode* curr = new TreeNode(n);
        if(start == end) return curr;
        int pos = search(inorder, start , end, n);
        curr->right = helper(inorder, postorder, pos+1 ,end, index);
        curr->left = helper(inorder, postorder, start, pos-1, index);
        return curr;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int index = postorder.size()-1;
        TreeNode* root = helper(inorder, postorder, 0 , postorder.size()-1, index);
        return root;
    }
};