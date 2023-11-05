vector<int> reverseLevelOrder(Node *root)
{
    vector<vector<int>> ans;
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        int levelSize = q.size();
        vector<int> temp;
        for(int i = 0 ; i < levelSize ; i ++){
            Node* node = q.front();
            q.pop();
            temp.push_back(node->data);
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
        }
        ans.push_back(temp);
        temp.clear();
    }
    vector<int> result;
    for(int i = ans.size() - 1 ; i >= 0 ; i--){
        for(auto k : ans[i]){
            result.push_back(k);
        }
    }
    return result;
}