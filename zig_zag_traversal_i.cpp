class Solution{
public:
    //Function to store the zig zag order traversal of tree in a list.
    vector <int> zigZagTraversal(Node* root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        vector<vector<int>> result;
        queue<Node*> q;
        q.push(root);
        bool flag = true;
        while(!q.empty()){
            vector<int> temp;
            int levelSize = q.size();
            for(int i = 0 ; i < levelSize ; i++){
                Node* node = q.front();
                q.pop();
                temp.push_back(node->data);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            if(flag){
                result.push_back(temp);
            }
            else{
                reverse(temp.begin(), temp.end());
                result.push_back(temp);
            }
            flag = !flag;
        }
        for(auto x : result){
            for(auto y : x){
                ans.push_back(y);
            }
        }
        return ans;
    }
};