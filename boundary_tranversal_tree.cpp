class Solution {
public:
    bool isLeaf(Node* root){
        return root->left == nullptr && root->right == nullptr;
    }
    void leftBoundary(Node* root, vector<int> &ans){
        root = root->left;
        while(root){
            if(!isLeaf(root)){
                ans.push_back(root->data);
            }
            if(root->left) root = root->left;
            else root = root->right;
        }
    }
    void rightBoundary(Node* root, vector<int> &ans){
        root = root->right;
        stack<int> st;
        while(root){
            if(!isLeaf(root)){
                st.push(root->data);
            }
            if(root->right) root = root->right;
            else root = root->left;
        }
        while(!st.empty()){
            ans.push_back(st.top());
            st.pop();
        }
    }
    void addLeaves(Node* root, vector<int> &ans){
        if(root == nullptr) return;
        if(isLeaf(root)){
            ans.push_back(root->data);
        }
        addLeaves(root->left, ans);
        addLeaves(root->right, ans);
    }
    vector <int> boundary(Node *root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        if(!isLeaf(root)){
            ans.push_back(root->data);
        }
        leftBoundary(root, ans);
        addLeaves(root, ans);
        rightBoundary(root, ans);
        return ans;
    }
};
