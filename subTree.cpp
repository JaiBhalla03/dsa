class Solution {
public:

    // Convert a given tree to a tree where every node contains sum of values of
    // nodes in left and right subtrees in the original tree
    int sumTree(Node* &node){
        if(node == nullptr){
            return 0;
        }
        int old = node->data;
        node->data = sumTree(node->left) + sumTree(node->right);
        return old + node->data;
    }
    void toSumTree(Node *node)
    {
        sumTree(node);
    }
};