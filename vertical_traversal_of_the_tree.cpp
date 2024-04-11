class Solution
{
public:
    //Function to find the vertical order traversal of Binary Tree.
    vector<int> verticalOrder(Node *root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        unordered_map<int, vector<int>> m;
        queue<pair<Node*, int>> q;

        q.push({root, 0});
        int mn = 0, mx = 0;
        while(!q.empty()){
            pair<Node*, int> p = q.front();
            Node* node = p.first;
            int hd = p.second;
            q.pop();
            m[hd].push_back(node->data);
            if(node->left){
                q.push({node->left, hd-1});
            }
            if(node->right){
                q.push({node->right, hd+1});
            }
            if (mn > hd)
                mn = hd;
            else if (mx < hd)
                mx = hd;
        }

        for(int i = mn ; i <= mx ; i++){
            vector<int> temp = m[i];
            for(auto x : temp){
                ans.push_back(x);
            }
        }

        return ans;
    }
};