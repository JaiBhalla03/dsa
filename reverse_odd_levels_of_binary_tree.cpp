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
    TreeNode* reverseOddLevels(TreeNode* root) {
        int count = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int levelSize = q.size();
            vector<TreeNode*> temp;
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode* node = q.front();
                q.pop();
                if(node->left) {
                    q.push(node->left);
                    temp.push_back(node->left);
                }
                if(node->right) {
                    q.push(node->right);
                    temp.push_back(node->right);
                }
            }
            count++;
            if(count%2 == 1){
                int front = 0;
                int rear = temp.size()-1;
                while(front < rear){
                    int t = temp[front]->val;
                    temp[front]->val = temp[rear]->val;
                    temp[rear]->val = t;
                    front++;
                    rear--;
                }
            }
            temp.clear();
        }
        return root;
    }
};