class Solution
{
public:
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    vector<int> topView(Node *root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        queue<pair<Node*, int>> q;
        map<int, int> mpp;
        q.push({root, 0});
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            Node* node = it.first;
            int line = it.second;
            if(mpp.find(line) == mpp.end()) mpp[line] = node->data;
            if(node->left){
                q.push({node->left, line-1});
            }
            if(node->right){
                q.push({node->right, line+1});
            }
        }
        for(auto x : mpp){
            ans.push_back(x.second);
        }
        return ans;
    }

};