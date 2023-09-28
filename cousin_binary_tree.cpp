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
    void findParent(TreeNode* root, int child, int &parent){
        if(root == nullptr) return;
        else{
            if(root->left && root->left->val == child){
                parent = root->val;
                return;
            }
            else if(root->right && root->right->val == child){
                parent = root->val;
                return;
            }
            else{
                findParent(root->left, child, parent);
                findParent(root->right, child, parent);
            }
        }
    }
    int findDepth(TreeNode* root, int n){
        queue<TreeNode*> q;
        q.push(root);
        int level=0;
        while(!q.empty()){
            int levelSize = q.size();
            for(int i = 0 ; i<levelSize ; i++){
                TreeNode* node = q.front();
                q.pop();
                if(node->val == n) return level;
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            level++;
        }
        return -1;
    }
    bool isCousins(TreeNode* root, int x, int y) {
        int parentX=-1;
        int parentY=-1;
        findParent(root, x, parentX);
        findParent(root, y, parentY);

        cout<<parentX <<" "<<parentY;
        return findDepth(root, x) == findDepth(root, y) && parentX != parentY;
    }
};