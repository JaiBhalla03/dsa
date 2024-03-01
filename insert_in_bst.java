class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        if(root == null) return new Node(Key);
        else if(root.data == Key) return root;
        else if(root.data < Key){
            root.right = insert(root.right, Key);
        }
        else{
            root.left = insert(root.left, Key);
        }
        return root;
    }
}