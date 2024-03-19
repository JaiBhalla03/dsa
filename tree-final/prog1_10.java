//import java.util.*;
///*
//* -> depth of the binary tree  DONE
//* -> reverse level order traversal  DONE
//* -> subtree of another tree  DONE
//* -> invert binary tree DONE
//* -> level order traversal  DONE
//* -> left view   DONE
//* -> right view   DONE
//* -> zig zag traversal   DONE
//* -> create a mirror from the given tree  DONE
//* -> leaf at the same level  DONE
//* */
//
//
//public class prog1_10 {
//    static class Node{
//        int data;
//        Node left;
//        Node right;
//        public Node(int data){
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    //SUBTREE OF ANOTHER TREE
//    public static boolean same(Node root1, Node root2){
//        if(root1 == null && root2 == null) return true;
//        if(root1 == null || root2 == null) return false;
//
//        return root1.data == root2.data && same(root1.left, root2.left) && same(root1.right, root2.right);
//    }
//    public static boolean subTree(Node t, Node s){
//        if(s == null) return true;
//        if(t == null) return false;
//        if(same(t, s)) return true;
//        return subTree(t.left, s) || subTree(t.right, s);
//    }
//    //INVERT BINARY TREE
//
//    public static void invert(Node root){
//        if(root == null) return;
//        Node temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invert(root.left);
//        invert(root.right);
//    }
//
//    //CREATE A MIRROR OF THE GIVEN TREE
//    public static void mirror(Node root){
//        if(root == null) return;
//        Node temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        if(root.left != null) mirror(root.left);
//        if(root.right != null) mirror(root.right);
//    }
//
//    //LEAF AT THE SAME LEVEL
//    public static boolean sameLevelLeaf(Node root){
//        int result = 0;
//        int level = 0;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            level++;
//            while(size-- > 0){
//                Node node = q.poll();
//                if(node.left == null && node.right == null){
//                    if(result == 0){
//                        result = level;
//                    }
//                    else{
//                        if(result != level) return false;
//                    }
//                }
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//        }
//        return true;
//    }
//
//    //FUNCTION THAT RETURNS THE DEPTH OF THE TREE
//    public static int depth(Node root){
//        if(root == null) return 0;
//        return 1 + Math.max(depth(root.left), depth(root.right));
//    }
//
//    //FUNCTION THAT RETURNS THE LEVEL ORDER TRAVERSAL
//    public static List<List<Integer>> levelOrder(Node root){
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//
//            List<Integer> temp = new ArrayList<>();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                temp.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//            ans.add(temp);
//        }
//        return ans;
//    }
//
//    //FUNCTION THAT RETURNS THE REVERSE LEVEL ORDER TRAVERSAL
//    public static List<List<Integer>> reverseLevelOrder(Node root){
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> temp = new ArrayList<>();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                temp.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//            ans.add(temp);
//        }
//        Collections.reverse(ans);
//        return ans;
//    }
//
//    //FUNCTION THAT RETURNS THE LEFT VIEW OF THE TREE
//    public static List<Integer> leftView(Node root){
//        List<Integer> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                if(i == 0) ans.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//        }
//        return ans;
//    }
//    //FUNCTION THAT RETURNS THE RIGHT VIEW OF THE TREE
//    public static List<Integer> rightView(Node root){
//        List<Integer> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                if(i == size-1) ans.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//        }
//        return ans;
//    }
//
//    //FUNCTION THAT RETURNS THE ZIG ZAG TRAVESAL OF TREE
//    public static List<List<Integer>> zigZagOrder(Node root){
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        boolean flag = true;
//        while(!q.isEmpty()){
//            int size = q.size();
//
//            List<Integer> temp = new ArrayList<>();
//            for(int i = 0 ; i < size ; i++){
//                Node node = q.poll();
//                temp.add(node.data);
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//            if(flag){
//                ans.add(temp);
//            }
//            else{
//                Collections.reverse(temp);
//                ans.add(temp);
//            }
//            flag = !flag;
//        }
//        return ans;
//    }
//    //function for inorder
//    public static void inorder(Node root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.print(root.data + " ");
//        inorder(root.right);
//    }
//
//    public static void main(String[] args){
//        Node r = new Node(2);
//        r.left = new Node(4);
//        r.right = new Node(5);
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.right.right.right = new Node(8);
//        System.out.println("Depth of the binary tree is the " + depth(root));
//        List<List<Integer>> levelOrder = levelOrder(root);
//        List<List<Integer>> reverseLevelOrder = reverseLevelOrder(root);
//        System.out.println("--------------------------------------------");
//        for(int i = 0 ; i < levelOrder.size() ; i++){
//            for(int j = 0 ; j < levelOrder.get(i).size() ; j++) System.out.print(levelOrder.get(i).get(j) + " ");
//            System.out.println();
//        }
//        System.out.println("--------------------------------------------");
//        for(int i = 0 ; i < reverseLevelOrder.size() ; i++){
//            for(int j = 0 ; j < reverseLevelOrder.get(i).size() ; j++) System.out.print(reverseLevelOrder.get(i).get(j) + " ");
//            System.out.println();
//        }
//        System.out.println("--------------------------------------------");
//        List<Integer> left = leftView(root);
//        for(int i = 0 ; i < left.size() ; i++){
//            System.out.print(left.get(i) + " ");
//        }
//        System.out.println("\n--------------------------------------------");
//        List<Integer> right = rightView(root);
//        for(int i = 0 ; i < right.size() ; i++){
//            System.out.print(right.get(i) + " ");
//        }
//        System.out.println("\n--------------------------------------------");
//        List<List<Integer>> zz = zigZagOrder(root);
//        for(int i = 0 ; i < zz.size() ; i++){
//            for(int j = 0 ; j < zz.get(i).size() ; j++){
//                System.out.print(zz.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("\n--------------------------------------------");
//        inorder(root);
//        System.out.println();
//        inorder(r);
//        System.out.println();
//        System.out.println(subTree(root, r));
//        System.out.println("\n--------------------------------------------");
//        inorder(r);
//        System.out.println("\n--------------------------------------------");
//        invert(r);
//        inorder(r);
//        mirror(r);
//        inorder(r);
//        System.out.println("\n--------------------------------------------");
//        System.out.println(sameLevelLeaf(root));
//        System.out.println(sameLevelLeaf(r));
//
//    }
//}
