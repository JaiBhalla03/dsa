vector<int> leftView(Node *root)
{
    vector<int> ans;
    if(root == nullptr) return ans;
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        int levelSize = q.size();
        for(int i = 0 ; i < levelSize ; i++){
            Node* node = q.front();
            q.pop();
            if(i == 0){
                ans.push_back(node->data);
            }
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
        }
    }
    return ans;
}