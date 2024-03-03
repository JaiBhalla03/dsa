class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public void helper(Node root, ArrayList<Integer> inorder){
        if(root == null) return;
        helper(root.right, inorder);
        inorder.add(root.data);
        helper(root.left, inorder);
    }
    public int kthLargest(Node root,int K)
    {
        ArrayList<Integer> inorder = new ArrayList<>();
        helper(root, inorder);
        return inorder.get(K-1);
    }
}