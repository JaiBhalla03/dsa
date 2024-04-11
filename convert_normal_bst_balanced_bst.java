class GfG
{
    public int length = 0;

    void helper(Node root, List<Integer> inorder){
        if(root == null) return;
        helper(root.left, inorder);
        inorder.add(root.data);
        helper(root.right, inorder);
    }

    Node createBST(List<Integer> inorder, int start , int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        Node newNode = new Node(inorder.get(mid));
        newNode.left = createBST(inorder, start, mid-1);
        newNode.right = createBST(inorder, mid + 1, end);
        return newNode;
    }

    Node buildBalancedTree(Node root)
    {
        List<Integer> inorder = new ArrayList<>();
        helper(root, inorder);
        Node ans = createBST(inorder, 0 , inorder.size() - 1);
        return ans;
    }
}