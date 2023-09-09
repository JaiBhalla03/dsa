public:
vector <int> bottomView(Node *root) {
    map<int, int> mpp;
    queue<pair<Node*, int>> q;
    q.push({root, 0});
    vector<int> ans;
    if(root == nullptr){
        return ans;
    }
    while(!q.empty()){
        auto it = q.front();
        q.pop();
        Node* node = it.first;
        int line = it.second;
        mpp[line] = node->data;
        if(node->left){
            q.push({node->left, line - 1});
        }
        if(node->right){
            q.push({node->right, line + 1});
        }
    }
    for(auto x : mpp){
        ans.push_back(x.second);
    }
    return ans;
}
};