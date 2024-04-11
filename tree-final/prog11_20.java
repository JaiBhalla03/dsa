/*
* 1. is balanced tree  DONE
* 2. is same tree  DONE
* 3. is isomorphic tree  DONE
* 4. height of the tree DONE
* 5. diameter DONE
* */

public class prog11_20 {
    static class Height{
        int h;
    }
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //function to check if the tree is balance or not
    public static int isBalanced(Node root){
        if(root == null) return 0;
        int lh = isBalanced(root.left);
        if(lh == -1) return -1;
        int rh = isBalanced(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh -rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    //function that check if the two trees are same or not
    public static boolean isSame(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    //function that checks if the 2 trees are isomorphic or not
    public static boolean isIsomorphic(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;
        boolean first = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        boolean second = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
        return first || second;
    }

    //function to find the height of the tree
    public static int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    //function to find the diameter of the tree

    public static int diameter(Node root, Height height){
        Height lh = new Height();
        Height rh = new Height();
        if(root == null){
            height.h = 0;
            return 0;
        }
        int ld = diameter(root.left, lh);
        int rd = diameter(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(rd, ld));
    }

    //function to print the tree in inorder
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args){
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(2);
        root.right.right.right = new Node(2);

        Node root1 = new Node(0);
        root1.left = new Node(2);
        root1.left.right = new Node(2);
        root1.right = new Node(1);


        inorder(root);
        System.out.println();
        System.out.println(isBalanced(root));
        System.out.println(isSame(root1, root));
        System.out.println(isIsomorphic(root1, root));
        System.out.println("height: " + height(root));
        Height h = new Height();
        System.out.println("diameter: " + diameter(root, h));
    }
}
