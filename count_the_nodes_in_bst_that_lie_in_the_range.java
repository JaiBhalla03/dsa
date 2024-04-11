class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    void helper(Node root, int[] count, int l, int h){
        if(root == null) return;
        helper(root.left, count, l, h);
        if(root.data >= l && root.data <= h) count[0]++;
        helper(root.right, count, l, h);
    }
    int getCount(Node root,int l, int h)
    {
        int count[] = new int[1];
        count[0] = 0;
        helper(root, count, l, h);
        return count[0];
    }
}
