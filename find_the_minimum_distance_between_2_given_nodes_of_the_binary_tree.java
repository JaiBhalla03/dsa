class GfG {
    Node LCA(Node root, int a, int b){
        if(root == null) return null;
        if(root.data == a || root.data == b) return root;
        Node leftLCA = LCA(root.left, a, b);
        Node rightLCA = LCA(root.right, a, b);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
    int dist(Node root, int a, int level){
        if(root == null) return -1;
        if(root.data == a) return level;
        int left = dist(root.left, a, level + 1);
        if(left == -1) return dist(root.right, a, level + 1);
        return left;
    }
    int findDist(Node root, int a, int b) {
        Node lca = LCA(root, a, b);
        int d1 = dist(lca, a, 0);
        int d2 = dist(lca, b, 0);
        return d1 + d2;
    }
}