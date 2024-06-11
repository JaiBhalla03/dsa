import java.util.*;

/*
* 1 lca in bst  (DONE)
* 2 search and insertion (DONE)
* 3 minimum element (DONE)
* 4 kth largest (DONE)
* 5 validate bst (DONE)
* 6 kth smallest (DONE)
* 7 binary tree to bst  (DONE)
* */

public class tree2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildTree(String str){
        String[] values = str.split(" ");
        if(values[0] == "N") return null;
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(i < values.length && !values[i].equals("N")){
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;
            if(i < values.length && !values[i].equals("N")){
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

//    function to build bst from the binary tree
    public static Node buildBST(int[] inorder, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        int n = inorder[mid];
        Node node = new Node(n);
        node.left = buildBST(inorder, start, mid - 1);
        node.right = buildBST(inorder, mid + 1, end);
        return node;
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Node node = q.poll();
                System.out.print(node.data + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            System.out.println();
        }
    }

    //lca of two node in bst
    public static Node lca(Node root, int p, int q){
        if(root == null) return null;
        if(root.data == p || root.data == q) return root;
        Node leftLCA = lca(root.left, p, q);
        Node rightLCA = lca(root.right, p, q);
        if(leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }


    //search in a bst
    public static boolean search(Node root, int target){
        while(root != null){
            if(target == root.data){
                return true;
            }
            else if(target < root.data){
                root = root.left;
            }
            else root = root.right;
        }
        return false;
    }

    //insertion in a bst
    public static Node insert(Node root, int x){
        if(root == null) return new Node(x);
        if(root.data == x) return root;
        if(x > root.data){
            root.right = insert(root.right, x);
        }
        else root.left = insert(root.left, x);
        return root;
    }

    //minimum element in the bst
    public static int minimum(Node root){
        if(root == null) return -1;
        if(root.left == null) return root.data;
        return minimum(root.left);
    }

    //function to find the kth smallest number
    public static int ans;
    public static int kthSmallest(Node root, int k){
        if(root == null) return 0;
        int left = 1 + kthSmallest(root.left, k);
        if(left == k) ans = root.data;
        return left + kthSmallest(root.right, k - left);
    }

    //function to find the kth largest number in the bst
    public static int kthLargest(Node root, int k){
        if(root == null) return 0;
        int right = 1 + kthLargest(root.right, k);
        if(right == k) ans = root.data;
        return right + kthLargest(root.left, k - right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] in = {1,2,3,4,5,6,7};
        Node root1 = buildBST(in, 0, in.length - 1);
//        inorder(root1);
//        System.out.println();
//        levelOrder(root1);
        ans = -1;
        System.out.println(kthLargest(root1, 3));
    }
}
