import java.util.*;

/*
* 1 lca in bst  (DONE)
* 2 search and insertion (DONE)
* 3 minimum element (DONE)
* 4 kth largest (DONE)
* 5 validate bst (DONE)
* 6 kth smallest (DONE)
* 7 binary tree to bst  (DONE)
* 8 predecessor and successor
* 9 check if the bst has a dead end or not
* 10 delete node in bst
* 11 flatten bst
* 12 preorder to postorder
* 13 count bst that are in a given range
* 14 populate inorder successor for all nodes
* 15 normal bst to balanced bst  (DONE)
* 16 merge bst
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

    //make the bst
    //first creating an unbalanced
    public static Node insert1(Node root, int x){
        if(root == null) return new Node(x);
        if(root.data == x) return root;
        else if(root.data > x) {
            root.left = insert(root.left, x);
        }
        else{
            root.right = insert(root.right, x);
        }
        return root;
    }
    public static int index = 0;
    public static void inorderBST(Node root, int[] inorder){
        if(root == null) return;
        inorderBST(root.left, inorder);
        inorder[index++] = root.data;
        inorderBST(root.right, inorder);
    }

    //balancing function
    public static Node balancing(int[] inorder, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        Node node = new Node(inorder[mid]);
        if(start == end) return node;
        node.left = balancing(inorder, start, mid - 1);
        node.right = balancing(inorder, mid + 1, end);
        return node;
    }

    //function to flatten bst(this is similar to flattening and binary tree)
    public static Node prev = null;
    public static void inorderHelper(Node root){
        if(root == null){
            return;
        }
        inorderHelper(root.left);
        prev.left = null;
        prev.right = root;
        prev = root;
        inorderHelper(root.right);
    }
    public static Node flatten(Node root){
        Node dummy = new Node(-1);
        prev = dummy;
        inorderHelper(root);
        prev.left = null;
        prev.right = null;
        Node ans = dummy.right;
        return ans;
    }

    //merging 2 bsts
    public static List<Integer> mergeBST(Node root1, Node root2){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        while(root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()){
            while(root1 != null){
                s1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                s2.push(root2);
                root2 = root2.left;
            }

            if(s2.isEmpty() || (!s1.isEmpty() && s1.peek().data <= s2.peek().data)){
                root1 = s1.peek();
                s1.pop();
                ans.add(root1.data);
                root1 = root1.right;
            }
            else{
                root2 = s2.peek();
                s2.pop();
                ans.add(root2.data);
                root2 = root2.right;
            }
        }
        return ans;
    }

    public static Node remove(Node root, int k){
        if(root == null) return root;
        if(root.data > k){
            root.left = remove(root.left, k);
            return root;
        }
        else if(root.data < k){
            root.right = remove(root.right, k);
            return root;
        }
        else if(root.left == null){
            Node temp = root.right;
            return temp;
        }
        else if(root.right == null){
            Node temp = root.left;
            return temp;
        }
        else{
            Node parent = root;
            Node succ = root.right;
            while(succ.left != null){
                parent = succ;
                succ = succ.left;
            }
            if(parent != root){
                parent.left = succ.right;
            }
            else{
                parent.right = succ.left;
            }
            root.data = succ.data;
            return root;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] inorder1 = {1,3,5};
        int[] inorder2 = {2,4,6};
        Node root1 = buildBST(inorder1, 0, inorder1.length - 1);
        Node root2 = buildBST(inorder2, 0, inorder2.length - 1);
        List<Integer> l = mergeBST(root1, root2);

        int[] inorder3 = new int[l.size()];
        int i = 0;
        for(Integer x : l){
            inorder3[i++] = x;
        }
        Node root3 = buildBST(inorder3, 0, inorder3.length - 1);
        levelOrder(root3);
        Node root4 = remove(root3, 5);
        levelOrder(root4);
    }
}
