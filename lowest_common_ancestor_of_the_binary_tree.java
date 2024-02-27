class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1,int n2)
    {
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node leftLCA = lca(root.left , n1 , n2);
        Node rightLCA = lca(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}

