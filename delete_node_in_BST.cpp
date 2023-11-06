Node *deleteNode(Node *root, int X) {
    if(root == nullptr){
        return root;
    }
    if(root->data > X){
        root->left = deleteNode(root->left, X);
        return root;
    }
    else if(root->data < X){
        root->right = deleteNode(root->right, X);
        return root;
    }
    if(root->left == nullptr){
        Node* temp = root->right;
        delete root;
        return temp;
    }
    else if(root->right == nullptr){
        Node* temp = root->left;
        delete root;
        return temp;
    }
    else{
        Node* succParent = root;
        Node* succ = root->right;
        while(succ->left != nullptr){
            succParent = succ;
            succ = succ->left;
        }
        if(succParent != root){
            succParent->left = succ->right;
        }
        else{
            succParent->right = succ->right;
        }
        root->data = succ->data;
        delete succ;
        return root;
    }
}