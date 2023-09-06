vector<int> leftView(Node *root)
{
    if(root == nullptr) return {};
    vector<int> temp;
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        int levelSize = q.size();
        for(int i = 0 ; i<levelSize ; i++){
            Node* node = q.front();
            q.pop();
            if(i == 0){
                temp.push_back(node->data);
            }
            if(node->left) q.push(node->left);
            if(node->right) q.push(node-> right);
        }
    }
    return temp;
}