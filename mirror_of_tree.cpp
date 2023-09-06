class Solution {
public:
    // Function to convert a binary tree into its mirror tree.
    void getMirror(Node* &node){
        Node* temp = node->left;
        node->left = node->right;
        node->right = temp;
    }

    void mirror(Node* node) {
        if(node == nullptr){
            return;
        }
        getMirror(node);
        mirror(node->left);
        mirror(node->right);
    }
};