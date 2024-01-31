class Solution {
public:
    Node* mirror1(Node* node){
        if(node == nullptr) return nullptr;
        Node* t = node->left;
        node->left = node->right;
        node->right = t;
        if(node->left){
            mirror1(node->left);
        }
        if(node->right){
            mirror1(node->right);
        }
        return node;
    }
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node* node) {
        node = mirror1(node);
    }
};