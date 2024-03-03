//brute force
class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    void helper(Node root, ArrayList<Integer> preorder){
        if(root == null) return;
        preorder.add(root.data);
        helper(root.left, preorder);
        helper(root.right, preorder);
    }

    void insert(Node node, int data){
        if(node.left == null && node.data > data){
            node.left = new Node(data);
        }
        if(node.right == null && node.data < data){
            node.right = new Node(data);
        }
        if(node.data > data){
            insert(node.left, data);
        }
        else if(node.data < data){
            insert(node.right, data);
        }
    }

    Node binaryTreeToBST(Node root)
    {
        if(root == null) return null;
        ArrayList<Integer> preorder = new ArrayList<>();
        helper(root, preorder);
        Collections.sort(preorder);
        Node node = new Node(preorder.get(0));
        for(int i = 1 ; i<preorder.size() ; i++){
            insert(node, preorder.get(i));
        }
        return node;
    }
}

//optimised way to do that
