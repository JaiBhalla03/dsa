class Tree
{

    //Function to check whether a binary tree is balanced or not.
    int helper(Node root){
        if(root == null) return 0;
        int lh = helper(root.left);
        if(lh == -1) return -1;
        int rh = helper(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
    boolean isBalanced(Node root)
    {
        return helper(root) >= 0;
    }
}