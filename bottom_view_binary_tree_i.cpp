class Solution {
public:
    vector<int> bottomView(Node *root) {
        vector<int> ans;
        if (!root)
            return ans;
        queue<pair<Node *, int>> q;
        map<int, int> mpp; // Using map instead of unordered_map for sorting keys
        q.push({root, 0});
        while (!q.empty())
        {
            auto it = q.front();
            q.pop();
            Node *node = it.first;
            int line = it.second;

            mpp[line] = node->data;

            if (node->left)
                q.push({node->left, line - 1});
            if (node->right)
                q.push({node->right, line + 1});
        }
        for (auto x : mpp)
        {
            ans.push_back(x.second);
        }
        return ans;
    }
};