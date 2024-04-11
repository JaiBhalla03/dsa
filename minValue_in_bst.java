class Tree {
    // Function to find the minimum element in the given BST.
    int minValue(Node node) {
        if(node == null) return -1;
        if(node.left == null) return node.data;
        return minValue(node.left);
    }
}