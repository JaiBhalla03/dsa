class Solution
{
public:
    Node* insert(Node* node, int data) {
        if(node == nullptr){
            return new Node(data);
        }
        if(node->data > data){
            node->left = insert(node->left, data);
        }
        if(node->data < data){
            node->right = insert(node->right, data);
        }
        return node;
    }

};