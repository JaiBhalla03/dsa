class Solution {
public:

    bool isLeaf(Node* root){
        if(root->left == nullptr && root->right == nullptr){
            return true;
        }
        return false;
    }
    void leftBoundary(Node* root, vector<int>& ans){
        root = root->left;
        while(root){
            if(!isLeaf(root)) ans.push_back(root->data);
            if(root->left) root = root->left;
            else root = root->right;
        }
    }
    void leafBoundary(Node* root, vector<int>& ans){
        if(root == nullptr) return;
        if(isLeaf(root)){
            ans.push_back(root->data);
            return;
        }
        leafBoundary(root->left, ans);
        leafBoundary(root->right, ans);
    }
    void rightBoundary(Node * root, vector<int>& ans){
        root = root->right;
        stack<int> stk;
        while(root){
            if(!isLeaf(root)) stk.push(root->data);
            if(root->right) root = root->right;
            else root = root->left;
        }
        while(!stk.empty()){
            ans.push_back(stk.top());
            stk.pop();
        }
    }
    vector <int> boundary(Node *root)
    {
        vector<int> ans;
        if(root == nullptr) return ans;
        if(!isLeaf(root)){
            ans.push_back(root->data);
        }
        leftBoundary(root, ans);
        leafBoundary(root, ans);
        rightBoundary(root, ans);
        return ans;
    }
};