/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    unordered_map<TreeNode*, TreeNode*> parent;
    void preorder(TreeNode* curr, TreeNode* par){
        if(curr == nullptr) return;
        parent[curr] = par;
        preorder(curr->left, curr);
        preorder(curr->right, curr);
    }
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        //first we need the parent of all the nodes
        preorder(root, nullptr);
        queue<TreeNode*> q;
        q.push(target);
        vector<int> ans;
        unordered_set<TreeNode*> visited;
        while(!q.empty() && k){
            k--;
            int levelSize = q.size();
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode* node = q.front();
                q.pop();
                visited.insert(node);
                if(!visited.count(node->left) && node->left) q.push(node->left);
                if(!visited.count(node->right) && node->right) q.push(node->right);
                if(!visited.count(parent[node]) && parent[node]) q.push(parent[node]);
            }
        }
        while(!q.empty()){
            TreeNode* node = q.front();
            q.pop();
            ans.push_back(node->val);
        }
        return ans;
    }
};