class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node node = null;
    void helper(Node root, ArrayList<Integer> preorder){
        if(root == null) return;
        helper(root.left, preorder);
        preorder.add(root.data);
        helper(root.right, preorder);
    }

    Node createBST(ArrayList<Integer> preorder, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(preorder.get(mid));
        node.left = createBST(preorder, start , mid-1);
        node.right = createBST(preorder, mid + 1, end);
        return node;
    }

    Node binaryTreeToBST(Node root)
    {
        if(root == null) return null;
        ArrayList<Integer> preorder = new ArrayList<>();
        helper(root, preorder);
        Collections.sort(preorder);
        node = createBST(preorder, 0, preorder.size() - 1);
        return node;
    }
}