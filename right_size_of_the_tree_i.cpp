class Solution
{
public:
    //Function to return list containing elements of right view of binary tree.
    vector<int> rightView(Node *root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            int levelSize = q.size();
            vector<int> temp;
            for(int i = 0 ; i < levelSize ; i++){
                Node* node = q.front();
                q.pop();
                temp.push_back(node->data);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            ans.push_back(temp[temp.size() - 1]);
        }
        return ans;
    }
};
