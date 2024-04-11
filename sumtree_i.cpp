class Solution {
public:

    // Convert a given tree to a tree where every node contains sum of values of
    // nodes in left and right subtrees in the original tree
    int solve(Node* &root){
        if(root == nullptr) return 0;
        int a = solve(root->left);
        int b = solve(root->right);
        int x = root->data;
        root->data = a  +b;
        return a + b + x;
    }
    void toSumTree(Node *node)
    {
        solve(node);
    }
};