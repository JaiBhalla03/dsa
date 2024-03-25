//import com.sun.security.jgss.GSSUtil;
//
//import java.util.*;
//
///*
//* 1-> right side view of the tree
//* 2-> diameter of the tree
//* 3-> flatten the tree to a linked list
//* 4-> lca
//* 5-> validate the bst
//* 6-> kth smallest element in bst
//* */
//
//public class prog10 {
//    static class TreeNode{
//        int data;
//        TreeNode left;
//        TreeNode right;
//        public TreeNode(int data){
//            this.data = data;
//            this.right = null;
//            this.left = null;
//        }
//    }
//
//    //function to build the tree
//    public static TreeNode buildtree(String str){
//        if(str.length() == 0 || str.charAt(0) == 'N') return null;
//        String[] s = str.split(" ");
//        Queue<TreeNode> q = new LinkedList<>();
//        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
//        q.add(root);
//        int i = 1;
//        while(!q.isEmpty()){
//            TreeNode node = q.poll();
//            if(i < s.length && !s[i].equals("N") && !s[i].equals("-1")){
//                node.left = new TreeNode(Integer.parseInt(s[i]));
//                q.add(node.left);
//            }
//            i++;
//            if(i < s.length && !s[i].equals("N") && !s[i].equals("-1")){
//                node.right = new TreeNode(Integer.parseInt(s[i]));
//                q.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
//
//    //function to inorderly traverse the binary tree
//    public static void inorder(TreeNode root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//
//    //function to print the right side view of the tree
//    public static void rightView(TreeNode root){
//        if(root == null) return;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        System.out.println("RIGHT SIZE VIEW OF THE TREE");
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0 ; i < size ; i++){
//                TreeNode node = q.poll();
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//                if(i == size - 1) System.out.print(node.data + " ");
//            }
//        }
//        System.out.println();
//    }
//    //function to print the diameter of the tree
//    static class Height{
//        int h;
//    }
//    public static int diameter(TreeNode root, Height height){
//        Height lh = new Height();
//        Height rh = new Height();
//        if(root == null){
//            height.h = 0;
//            return 0;
//        }
//        int ld = diameter(root.left, lh);
//        int rd = diameter(root.right, rh);
//        height.h = Math.max(lh.h, rh.h) + 1;
//        return Math.max(lh.h + rh.h + 1 , Math.max(ld,rd));
//    }
//    //function to flatten the tree to a linked list
//    public static void flatten(TreeNode root){
//        TreeNode curr = root;
//        while(curr != null){
//            if(curr.left != null){
//                TreeNode rightmost = curr.left;
//                while(rightmost.right != null) rightmost = rightmost.right;
//                rightmost.right = curr.right;
//                curr.right = curr.left;
//                curr.left = null;
//            }
//            curr = curr.right;
//        }
//    }
//
//    //function that returns the lca of the binary tree
//    public static TreeNode lca(TreeNode root, int p, int q){
//        if(root == null) return null;
//        if(root.data == p || root.data == q) return root;
//        TreeNode leftLCA = lca(root.left, p, q);
//        TreeNode rightLCA = lca(root.right, p, q);
//        if(leftLCA != null && rightLCA != null) return root;
//        return leftLCA != null ? leftLCA : rightLCA;
//    }
//    //function validates the binary tree
//
//    public static boolean validate(TreeNode root){
//        List<Integer> inorder = new ArrayList<>();
//        helper(root, inorder);
//        for(int i = 1 ; i < inorder.size() ; i++){
//            if(inorder.get(i-1) > inorder.get(i)) return false;
//        }
//        return true;
//    }
//    public static void helper(TreeNode root, List<Integer> l){
//        if(root == null) return;
//        helper(root.left, l);
//        l.add(root.data);
//        helper(root.right, l);
//    }
//    //function that finds the kth smallest element in the bst
//    public static int kthSmallest(TreeNode root, int k){
//        List<Integer> l = new ArrayList<>();
//        helper(root, l);
//        return l.get(k-1);
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        TreeNode root = buildtree(str);
//
////        inorder(root);
////        rightView(root);
////        System.out.println("DIAMETER OF THE BINARY TREE");
////        Height h = new Height();
////        System.out.println(diameter(root, h));
////        flatten(root);
//        int p = sc.nextInt();
//        int q = sc.nextInt();
//        TreeNode node = lca(root, p, q);
//        if(node != null) System.out.println(node.data);
//        else System.out.println("none");
//    }
//}
