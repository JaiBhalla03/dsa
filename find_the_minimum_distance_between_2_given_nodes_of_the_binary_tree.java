//function to print the lca of the two nodes
    public static Node lca(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
    //function to print minimum distance between two nodes
    public static int distance(Node root, int a, int level){
        if(root == null) return -1;
        if(root.data == a) return level;
        int left = distance(root.left, a, level+1);
        if(left != -1) return left;
        return distance(root.right, a, level + 1);
    }
    public static int minDistance(Node root, int a, int b){
        Node lca = lca(root, a, b);
        int d1 = distance(lca, a, 0);
        int d2 = distance(lca, b, 0);
        System.out.println(d1 + " " + d2);
        return d1 + d2;
    }

