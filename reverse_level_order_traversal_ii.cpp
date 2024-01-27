/*
struct Node
{
    int data;
    Node* left;
    Node* right;
}; */
vector<int> reverseLevelOrder(Node *root)
{
    vector<int> ans;
    queue<Node*> q;
    vector<vector<int>> result;
    q.push(root);
    while(!q.empty()){
        int levelSize = q.size();
        vector<int> temp;
        for(int i = 0 ; i < levelSize ; i++){
            Node* curr = q.front();
            q.pop();
            temp.push_back(curr->data);
            if(curr->left){
                q.push(curr->left);
            }
            if(curr->right){
                q.push(curr->right);
            }
        }
        result.push_back(temp);
    }
    for(int i = result.size() -1  ; i >= 0 ; i--){
        for(int j = 0 ; j < result[i].size() ; j++){
            ans.push_back(result[i][j]);
        }
    }
    return ans;
}